<%@page import="org.apache.coyote.Request"%>
<%@page import="entiity.Places"%>
<%@page import="manager.PlacesManager"%>
<%@page import="entiity.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page import="manager.EmpManager"%>
<%@page import="manager.ScheduleManager"%>
<%@page import="entiity.Schedule"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.Time"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<title>Manager Page</title>
</head>
<body>
	<%
	/* ScheduleManager scheduleManager = new ScheduleManager();
	Integer emp_id = (Integer) (request.getAttribute("emp_id")); */
	EmpManager empManager = new EmpManager();
	ArrayList<Employee> empList = new ArrayList();

	PlacesManager placesManager = new PlacesManager();
	ArrayList<Places> placeList = new ArrayList();

	placeList = placesManager.getPlaceList();

	ScheduleManager scheduleManager = new ScheduleManager();
	ArrayList<Schedule>  = new ArrayList();

	scheduleList = scheduleManager.getSchedulesList();

	empList = empManager.getEmpList();

	String msg = (String) session.getAttribute("msg");
	String req = (String) session.getAttribute("req");
	if (msg != null) {
	%>
	<p><%=msg%></p>
	<%
	}
	%>

	<div class="container">
		<div class="row">
			<div class="col-6">
				<h1>Security List</h1>
				<table style="border: 2px solid" class="table table-sm"
					class="table table-hover">
					<thead>
						<tr class="table-warning">
							<th scope="col">#</th>
							<th scope="col">Emp_id</th>
							<th scope="col">Name</th>
							<th scope="col">Leaves</th>
							<th scope="col">Duty</th>
							<th scope="col">Salary</th>
						</tr>
					</thead>
					<%
					for (int i = 0; i < empList.size(); i++) {
						int emp_id = empList.get(i).getEmp_id();
						String name = empList.get(i).getEmp_name();
						int leave = empList.get(i).getLeaves();
						int duty = empList.get(i).getDuty();
						int salary =empList.get(i).calculateSalary(duty);
						int index = i + 1;
					%>

					<tbody>
						<tr class="table-infor">
							<th scope="row"><%=index%></th>
							<td><%=emp_id%></td>
							<td><%=name%></td>
							<td><%=leave%></td>
							<td><%=duty%></td>
							<td><%=salary%></td>
						</tr>
					</tbody>
					<%
					}
					%>
				</table>
				<button type="submit">
					<a href="index.html">Back</a>
				</button>
			</div>

			<div class="col-6">
				<form action="createScheduleRegister" method="post">
					<div class="form-group">
						<label for="exampleFormControlSelect1">Select Emp_id</label> <select
							class="form-control" class="custom-select"
							id="validationCustom04" required name="emp_id">
							<%
							for (int i = 0; i < empList.size(); i++) {
								int emp_id = empList.get(i).getEmp_id();
							%>
							<option value="<%=emp_id%>"><%=emp_id%></option>
							<%
							}
							%>
						</select>
						<div class="invalid-feedback">Please select a valid id</div>
					</div>
					<div class="form-group">
						<label for="date" for="validationCustom03">Select date</label> <input
							type="date" id="validationCustom03" required name="date"
							class="form-control">
						<div class="invalid-feedback">Please select a valid date</div>
					</div>
					<div class="form-group">
						<label for="exampleFormControlSelect1">Select Place</label> <select
							class="form-control" class="custom-select"
							id="validationCustom04" required name="place">
							<%
							for (int i = 0; i < placeList.size(); i++) {
								String place_name = placeList.get(i).getName();
							%>
							<option value="<%=place_name%>"><%=place_name%></option>
							<%
							}
							%>
						</select>
						<div class="invalid-feedback">Please select a valid place</div>
					</div>
					<div class="form-group">
						<label for="time">Select Start time</label>
						<legend>
							<input type="time" name="startTime" class="form-control"
								id="validationCustom03" required>
						</legend>
						<div class="invalid-feedback">Please select a valid time</div>

					</div>
					<div class="form-group">
						<label for="time">Select End time</label>

						<legend>
							<input type="time" name="endTime" class="form-control"
								id="validationCustom03" required>
						</legend>
						<div class="invalid-feedback">Please select a valid time</div>

					</div>
					<button type="submit" class="btn btn-primary" data-toggle="modal"
						data-target="#staticBackdrop">Create Schedule</button>
				</form>
			</div>
		</div>

		<h1>Schedule</h1>
		<div class="row">
			<div class="col-6">
				<table style="border: 2px solid" class="table table-sm"
					class="table table-hover">
					<thead>
						<tr class="table-warning">
							<th scope="col">#</th>
							<th scope="col">Schedule id</th>
							<th scope="col">emp_id</th>
							<th scope="col">Place</th>
							<th scope="col">Date</th>
							<th scope="col">Start time</th>
							<th scope="col">End time</th>
						</tr>
					</thead>
					<%
					for (int i = 0; i < scheduleList.size(); i++) {
						int id = scheduleList.get(i).getId();
						int emp_id = scheduleList.get(i).getEmp_id();
						String place = scheduleList.get(i).getPlace();
						Date date = scheduleList.get(i).getDate();
						Time start = scheduleList.get(i).getStart();
						Time end = scheduleList.get(i).getEnd();
						int index = i + 1;
					%>
					<tbody>
						<tr class="table-infor">
							<th scope="row"><%=index%></th>
							<td><%=id%></td>
							<td><%=emp_id%></td>
							<td><%=place%></td>
							<td><%=date%></td>
							<td><%=start%></td>
							<td><%=end%></td>
						</tr>
					</tbody>
					<%
					}
					%>
				</table>
			</div>

			<div class="col-6">
				<h1>Request List</h1>
				<table style="border: 2px solid" class="table table-sm"
					class="table table-hover">
					<thead>
						<tr class="table-warning">
							<th scope="col">#</th>
							<th scope="col">emp_id</th>
							<th scope="col">Request Over Duty</th>
							<th scope="col">Request Leave</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<%
					for (int i = 0; i < empList.size(); i++) {
						int emp_id = empList.get(i).getEmp_id();
						int reqDuty = empList.get(i).getReqDuty();
						
						int reqLeave = empList.get(i).getReqLeave();
						int index = i + 1;
					%>
					<tbody>
						<tr class="table-infor">
							<th scope="row"><%=index%></th>

							<td><label name="emp_id"><%=emp_id%></label></td>
							<td>
								<form action="requestServlet" method="post">
									<div class="row">
										<div class="col-3">
											<%=reqDuty%>
										</div>
										<div class="col-3">
											<button type="submit" value="acceptDuty" name="acceptDuty">Accept</button>
										</div>
										<div class="col-3">
											<button type="submit" value="rejectDuty" name="rejectDuty">Reject</button>
										</div>
										<input type="hidden" name="emp_id" value="<%=emp_id%>"></input>
									</div>
								</form>
							</td>

							<td>
								<form action="requestServlet" method="post">
									<div class="row">
										<div class="col-3">
											<%=reqLeave%>
										</div>

										<div class="col-3">
											<button type="submit" value="acceptLeave"
												name="acceptLeave">Accept</button>
										</div>
										<div class="col-3">
											<button type="submit" value="rejectLeave" name="rejectLeave">Reject</button>
										</div>

									</div>
									<input type="hidden" name="emp_id" value="<%=emp_id%>"></input>
								</form>
							</td>

						</tr>
					</tbody>
					<%
					}
					%>
				</table>
			</div>
		</div>
	</div>




	<!-- 	<div class="modal fade" id="staticBackdrop" data-backdrop="static" -->
	<!-- 		data-keyboard="false" tabindex="-1" -->
	<!-- 		aria-labelledby="staticBackdropLabel" aria-hidden="true"> -->
	<!-- 		<div class="modal-dialog"> -->
	<!-- 			<div class="modal-content"> -->
	<!-- 				<div class="modal-header"> -->
	<!-- 					<h5 class="modal-title" id="staticBackdropLabel">Message</h5> -->
	<!-- 					<button type="button" class="close" data-dismiss="modal" -->
	<!-- 						aria-label="Close"> -->
	<!-- 						<span aria-hidden="true">&times;</span> -->
	<!-- 					</button> -->
	<!-- 				</div> -->
	<!-- 				<div class="modal-body"> -->

	<!-- 					<p>create schedule unsuccess</p> -->

	<!-- 				</div> -->
	<!-- 				<div class="modal-footer"> -->
	<!-- 					<button type="button" class="btn btn-secondary" -->
	<!-- 						data-dismiss="modal">Close</button> -->
	<!-- 				</div> -->
	<!-- 			</div> -->
	<!-- 		</div> -->
	<!-- 	</div> -->


	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
		crossorigin="anonymous"></script>
</body>
</html>