$(document).ready(function(){
	$("input").focus(function(){
        $($(this)).css("border-color", "");
        $('#error-'+$(this).attr('id')).hide();
    });
	
	$( "select" ).change(function() {
		$($(this)).css("border-color", "");
        $('#error-'+$(this).attr('id')).hide();
	});
	
	$( "select" ).focus(function() {
		$($(this)).css("border-color", "");
        $('#error-'+$(this).attr('id')).hide();
	});
	
	$( "textarea" ).focus(function() {
		$($(this)).css("border-color", "");
        $('#error-'+$(this).attr('id')).hide();
	});
});
var isValid = '';
function validate( value ){
	isValid = true;
	resetError();
	var errorColor = "#F32C2C";
	$('.error-'+value).hide();
    $('.'+value).each(function(){
   		var pId = $(this).attr('id');
   		var keydata = $('#'+pId).attr("key");
   		console.log(keydata);
       	var keyArr = keydata.split('-');	
        $("").insertAfter('#'+pId);
        $("#"+pId+"").css("border-color", ""); 
       	var inputValue = ($(this).val()).trim();
       	var length = keyArr.length;
       	
       	for (i = 1; i < length ; i++) {
       		if (keyArr[i]==='e') {
       			if(inputValue===''){
       				$("<span id='error-"+pId+"' class='error-"+value+" error'>This field is required.</span>").insertAfter('#'+pId);
       				$("#"+pId+"").css("border-color", errorColor); 
       				isValid=false;
       				length=i;
       				break;
       			}
       		}else if (keyArr[i]==='n') {
       			if(isNaN(inputValue)){
       				$("<span id='error-"+pId+"' class='error-"+value+" error'>Please enter valid format</span>").insertAfter('#'+pId);
       				$("#"+pId+"").css("border-color", errorColor);
       				isValid=false;
       				length=i;
       				break;
       			}
       		}else if (keyArr[i]==='em') {
       			if(!isEmail(inputValue)){
       				$("<span id='error-"+pId+"' class='error-"+value+" error'>Please enter a valid email address.</span>").insertAfter('#'+pId);
       				$("#"+pId+"").css("border-color", errorColor);
       				isValid=false;
       				length=i;
       				break;
       			}
       		}else if (keyArr[i]==='s') {
       			if(inputValue==0 || inputValue==''){
       				$("<span id='error-"+pId+"' class='error-"+value+" error'>Please select a option.</span>").insertAfter('#'+pId);
       				$("#"+pId+"").css("border-color", errorColor);
       				isValid=false;
       				length=i;
       				break;
       			}
       		}else if (keyArr[i].substring(0,3)==="min") {
				var res = keyArr[i].substring(3,keyArr[i].length);
       			if(res>inputValue.length){
       				$("<span id='error-"+pId+"' class='error-"+value+" error'>Your value must be at least "+res+" characters long</span>").insertAfter('#'+pId);
       				$("#"+pId+"").css("border-color", errorColor);
       				isValid=false;
       				length=i;
       				break;
       			}
       		};
		}
	    
    });
};

function isEmail(email) {
	var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	return regex.test(email);
}

function isMinimum(value) {
	var regex = /\b\w{4,}\b/;
	return regex.test(value);
}
function resetError() {
	$("input").css("border-color", "");
	$("select").css("border-color","");
	$("textarea").css("border-color","");
	$('.error').hide();
}
