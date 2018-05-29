<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Teacher - School Management</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css "/>" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery.min.js "/>"></script>
    <script src="<c:url value="/resources/js/popper.min.js "/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js "/>"></script>
    <script src="<c:url value="/resources/js/customValidation.js "/>"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.min.css" rel="stylesheet"/>
</head>
<style>
    #background {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-image: url('resources/images/bg.jpg');
        background-repeat: no-repeat;
        background-attachment: fixed;
        background-size: 100%;
        opacity: 0.4;
        filter: alpha(opacity=40);
    }
    
    #header-title {
        text-align: center;
        margin: 25px;
        text-transform: uppercase;
    }
    
    .table {
        border: 1px solid #dee2e6;
    }
    
    .card {
        background-color: #fbfbfb;
    }
    
    #add-btn {
        float: right;
    }
    
    .span3 {
        max-height: 300px;
        overflow-y: auto;
        margin-bottom: 15px;
    }
    
    .custom-btn {
        cursor: pointer;
    }
    .error{
    	color: #bd0000;
    	font-size: 13px;
    }
</style>

<body onload="loadTable();">
    <div id="background"></div>
    <div class="container">
        <div class="row">
            <div class="col-12" id="header-title">
                <h2>Teacher Management Panel</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-body">
                        <div class="span3">
                            <table id="teacher-table" class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>First Name</th>
                                        <th>Last Name</th>
                                        <th>Email</th>
                                        <th>Gender</th>
                                        <th>Birthday</th>
                                        <th>Experience</th>
                                        <th>Degree Code</th>
                                        <th style="text-align:right;">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                        <a href="<c:url value='/'/>"><button type="button" id="home-btn" class="btn btn-sm" >Home</button></a>
                        <button type="button" id="add-btn" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#teacherFormModel">Add Teacher</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- The Modal -->
        <div class="modal fade" id="teacherFormModel">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title" id="tch-modal-title">Add New Teacher</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <!-- Modal body -->
                    <div class="modal-body">
                        <div class="card">

                            <article class="card-body">
                                <form>
                                	<input type="hidden" id="tec-id" value="0">
                                    <div class="form-row">
                                        <div class="col form-group">
                                            <label>First name </label>
                                            <input type="text" id="fName" class="tch form-control" key="tch vd-e" placeholder="">
                                        </div>
                                        <!-- form-group end.// -->
                                        <div class="col form-group">
                                            <label>Last name</label>
                                            <input type="text" id="lName" class="tch form-control" key="tch vd-e" placeholder=" ">
                                        </div>
                                        <!-- form-group end.// -->
                                    </div>
                                    <!-- form-row end.// -->
                                    <div class="form-group">
                                        <label>Email address</label>
                                        <input type="email" id="email" class="tch form-control" key="tch vd-e-em"  placeholder="">
                                    </div>
                                    <!-- form-group end.// -->
                                    <div class="form-group">
                                        <label class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="gender" id="gender" value="m">
                                            <span class="form-check-label"> Male </span>
                                        </label>
                                        <label class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="gender" id="gender" value="f">
                                            <span class="form-check-label"> Female</span>
                                        </label>
                                    </div>
                                    <!-- form-group end.// -->
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label>Birthday</label>
                                            <input class="tch form-control" readonly="readonly" data-date-format="dd/mm/yyyy" key="tch vd-e" placeholder="01/01/1999" id="dob">
                                        </div>
                                        <!-- form-group end.// -->
                                        <div class="form-group col-md-6">
                                        
                                            <label>Experience</label>
                                             <input type="text" id="experience" class="tch form-control" maxlength="2" key="tch vd-e-n" placeholder="">
                                        </div>
                                        <!-- form-group end.// -->
                                    </div>
                                    <!-- form-row.// -->
                                    <div class="form-row">
	                                    <div class="form-group col-md-6">
	                                        <label>Contact Number</label>
	                                        <input class="tch form-control" type="text" maxlength="10" key="tch vd-e-n-min10" id="contactNumber">	                                    
	                                    </div>
	                                    <div class="form-group col-md-6">
	                                        <label>Degree Code</label>
	                                        <input class="tch form-control" type="text" maxlength="10" key="tch vd-e" id="degreeCode">
	                                    </div>
	                                    <!-- form-group end.// -->
                                    </div>
                                </form>
                            </article>
                        </div>
                        <!-- card.// -->
                    </div>
                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" onClick="validate('tch');" id="tch-submit">Save </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript">
	$('#dob').datepicker({
	    weekStart: 1,
	    daysOfWeekHighlighted: "6,0",
	    autoclose: true,
	    todayHighlight: true,
	});
	$('#dob').datepicker("setDate", new Date());
	
	//load teacher records and refresh table
    function loadTable() {
        $.ajax({
            url: "/SchoolManagement/teacher/all",
            type: 'GET',
            dataType: 'json', // added data type
            success: function(res) {
                $("#teacher-table tbody").html("");
                var row = "<tr><td colspan='8' style='text-align: center; background-color: #f7f7f7; color: #a2a2a2;'> No records found  </td>"; 
                if(res.length!=0){
                	row = "";
	                for (var i = 0; i < res.length; i++) {
	                    var row = "<tr>" + "<td>" + res[i].firstName + "</td>" 
	                    			+ "<td>" + res[i].lastName + "</td>" 
	                    			+ "<td>" + res[i].email + "</td>" 
	                    			+ "<td>" + getGenderName(res[i].gender) + "</td>" 
	                    			+ "<td>" + res[i].dateOfBirth + "</td>" 
	                    			+ "<td>" + res[i].experience + "</td>" 
	                    			+ "<td>" + res[i].degreeCode + "</td>" 
	                    			+ "<td align='right'>" + "<span class='badge badge-info custom-btn' id='" + res[i].teacherId + "' onclick='getRecordById(this.id)'>Edit</span> " 
	                    			+ "<span class='badge badge-danger custom-btn' id='" + res[i].teacherId + "' onclick='deleteTeacher(this)'>Delete</span>" + " </td>" 
	                    		+ "</tr>";
		                $("#teacher-table tbody").append(row);
	                }
                }else{
                	$("#teacher-table tbody").append(row);
                }
        	clearModelInput();
            }
        });
    }
    
    function getGenderName(type){
    	if(type=='m'){
    		return 'Male';
    	}else{
    		return 'Female';
    	}
    }
    
    //delete teacher record
    function deleteTeacher(row) {
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/SchoolManagement/teacher/remove/"+row.id,
            dataType: 'json',
            timeout: 600000,
            success: function(data) {
                alert(data['msg']);
                $(row).closest('tr').remove();
                loadTable();
            },
            error: function(e) {
                console.log(e)
                alert(data['error']);
            }
        });
    }
    
    //student creating and updating 
    $("#tch-submit").click(function(){
    	if(isValid){
    		$('#teacherFormModel').modal('hide');
	    	var url = "/SchoolManagement/teachera/add";
	    	var data = {}
	    	if($("#tec-id").val()!=0){
	    		url = "/SchoolManagement/teacher/update/";
	    		data["teacherId"] = $("#tec-id").val();
	    	}
			data["firstName"] = $("#fName").val();
			data["lastName"] = $("#lName").val();
			data["email"] = $("#email").val();
			data["gender"] = $('input[name=gender]:checked').val();
			data["dateOfBirth"] = $("#dob").val();
		 	data["experience"] = $("#experience").val();
		 	data["contactNumber"] = $("#contactNumber").val();
			data["degreeCode"] = $("#degreeCode").val();
			
			$.ajax({
	            type: "POST",
	            contentType: "application/json",
	            url: url,
	            data: JSON.stringify(data),
	            dataType: 'json',
	            timeout: 600000,
	            success: function (data) {
	            	alert(data['msg']);
	            	loadTable();
	            },
	            error: function (e) {
	            	console.log(e)
	            	alert(data['error']);
	            }
			});
    	}
    });
    
    //get record details by id
    function getRecordById(id) {
    	changeModelUIforUpdate();
    	$('#teacherFormModel').modal('show'); 
        $.ajax({
            url: "/SchoolManagement/teacher/"+id,
            type: 'GET',
            dataType: 'json',
            success: function(res) {
            	console.log(res)
                $("#fName").val(res.firstName);
        		$("#lName").val(res.lastName);
        		$("#email").val(res.email);
        		$("input[name=gender][value=" + res.gender + "]").prop('checked', true);
        		$("#dob").val(res.dateOfBirth);
        		$("#experience").val(res.experience);
        		$("#contactNumber").val(res.contactNumber);
        		$("#degreeCode").val(res.degreeCode);
        		$("#tec-id").val(res.teacherId);
            }
        });
    }
    
    //clear all input
    function clearModelInput(){
    	$("#fName").val("");
		$("#lName").val("");
		$("#email").val("");
		$("input[name=gender]").prop('checked', false);
		$("#dob").val("");
		$("#experience").val("");
		$("#contactNumber").val("");
		$("#degreeCode").val("");
		$("#tec-id").val(0);
    }
    
    function changeModelUIforUpdate(){
    	$('#tch-modal-title').html('Update Teacher');
    	$('#tch-submit').html('Update');
    }
    function changeModelUIforAdd(){
    	$('#tch-modal-title').html('Add New Teacher');
    	$('#tch-submit').html('Save');
    }
    
    //execute after model window close
    $('#teacherFormModel').on('hidden.bs.modal', function () {
    	clearModelInput();
    	changeModelUIforAdd();
    	resetError();
    });
    
</script>

</html>