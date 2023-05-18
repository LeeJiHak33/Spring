function make_row(item){
	  const tr= $("<tr>");
                tr.attr("data-id",item.id);
                
                const td_id =$("<td>");
                
                td_id.text(item.id);
                tr.append(td_id);

                const td_name=$("<td>");
                td_name.addClass("name");
                td_name.text(item.name);
                tr.append(td_name);

                const td_nameEng=$("<td>");
                td_nameEng.addClass("name_eng");
                td_nameEng.text(item.nameEng);
                tr.append(td_nameEng);

                const td_url=$("<td>");
                td_url.addClass("url");
                td_url.text(item.url)
                tr.append(td_url);
                
                const td_manager=$("<td>");
                
                const button_delete=$("<button>");
                button_delete.addClass("delete");
                button_delete.text("삭제");
                td_manager.append(button_delete);
                
                const button_update=$("<button>");
                button_update.addClass("update");
                button_update.text("변경")
                td_manager.append(button_update);
                
                tr.append(td_manager);
                
                $("#list").append(tr);
                
               
}

function close_modal(){
	$(".modal").addClass("empty_list");
}
$(function(){
	$(".cancel").click(e =>{
		close_modal();
	})
	$("#add").click(e=>{
		close_modal();
		$("#add_modal").removeClass("empty_list");
	});
	$("#add_modal .submit").click(e=>{
		$("#add_modal").addClass("empty_list");
		const item={
			name:$("#add_modal input[name='name']").val(),
			nameEng:$("#add_modal input[name='nameEng']").val(),
			url:$("#add_modal input[name='url']").val(),
		};
		console.log(item);
		$.ajax("/api/publisher",{
			method:"POST",
			contentType:"application/json",
			dataType:"json",
			data:JSON.stringify(item),
			success:result =>{
				console.log(result);
				if(result.id){
					make_row(result);
					$("#add_modal input").val("");	
					$("#empty_list").addClass("empty_list");
					close_modal();
				}				
			}
		});
	});
    $("tbody").on("click",".delete",function(e){
        const button=$(e.target);
        
        const tr=button.closest("tr");
        
        close_modal();
        console.log(`삭제 ${tr.data("id")}`);
        
        const item={
			id:tr.data("id")
		};
		
        $.ajax("/api/publisher",{
			method:"DELETE",
			contentType:"application/json",
        	dataType: "json",
        	data: JSON.stringify(item),
        	success: result =>{
				console.log(result);
				tr.remove();
				
				const list=$("#list >  tr");
				
				if(list.length==1){
					$("#empty_list").removeClass("empty_list");
				}
			}
		});
    });
    
	$("tbody").on("click",".update",function(e){
        const button=$(e.target);
        
        const tr=button.closest("tr");
        
        console.log(`변경 ${tr.data("id")}`);
        close_modal();
        $("#update_modal").removeClass("empty_list");
        
        
        $("#update_modal input[name='id']").val(tr.data("id"));
        
        const name=tr.find(".name").text();
        $("#update_modal input[name='name']").val(name);
        
        const nameEng=tr.find(".name_eng").text();
        $("#update_modal input[name='nameEng']").val(nameEng);
        
        const url=tr.find(".url").text();
        $("#update_modal input[name='url']").val(url);
        
        
        
    });
    $("#update_modal  .submit").click(e =>{
		
		const item={
			id:$("#update_modal input[name='id']").val(),
			name:$("#update_modal input[name='name']").val(),
			nameEng:$("#update_modal input[name='nameEng']").val(),
			url:$("#update_modal input[name='url']").val(),
		};
		
		$.ajax("/api/publisher",{
			method:"PUT",
			contentType:"application/json",
			dataType:"json",
			data:JSON.stringify(item),
			success:result =>{
				console.log(result);
				
				$(`tr[data-id='${result.id}'] td.name `).text(result.name);
				$(`tr[data-id='${result.id}'] td.name_eng `).text(result.nameEng);
				$(`tr[data-id='${result.id}'] td.url `).text(result.url);	
				
				close_modal();
			}
		});
	});
    $.ajax("/api/publisher",{
        method:"GET",
        contentType:"application/json",
        dataType: "json",
        success:result => {
            //object--> string
            //JSON.stringify(object)
            //string-->object
            console.log(result);
			
            
            result.forEach(item => {
              make_row(item);
            });
             if(result.length >0){
					//document.querySelector('#hidden').style.display = 'none';
					$("#empty_list").addClass("empty_list");
					
				}
				else{
					$("#empty_list").removeClass("empty_list");
				}
        } ,
        //error: 
    });
});