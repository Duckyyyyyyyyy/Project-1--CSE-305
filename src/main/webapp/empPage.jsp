<!doctype html>
<%@page import="manager.EmpManager"%>
<%@page import="dao.EmpDao"%>
<%@page import="entiity.Places"%>
<%@page import="entiity.Schedule"%>
<%@page import="java.util.ArrayList"%>
<%@page import="manager.ScheduleManager"%>
<%@page import="dao.ScheduleDao"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.Time"%>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">

<title>Employee Page</title>
</head>
<body>
	<%
	Integer emp_id = (Integer) session.getAttribute("emp_id");
	ScheduleManager scheduleManager = new ScheduleManager();
	ArrayList<Schedule> scheduleList = new ArrayList();

	scheduleList = scheduleManager.getScheduleById(emp_id);

	EmpManager empManager = new EmpManager();
	int duty = empManager.getDuty(emp_id);
	int salary=empManager.calculateSalary(duty);
	int leaves = empManager.getLeaves(emp_id);
	%>
	<p><%=emp_id%></p>
	<div class="container">
		<h1>Schedule</h1>
		<div class="row">
			<div class="col-6">
				<table style="border: 2px solid" class="table table-sm"
					class="table table-hover">
					<thead>
						<tr class="table-warning">
							<th scope="col">#</th>
							<th scope="col">Schedule id</th>
							<th scope="col">Place</th>
							<th scope="col">Date</th>
							<th scope="col">Start time</th>
							<th scope="col">End time</th>
						</tr>
					</thead>
					<%
					for (int i = 0; i < scheduleList.size(); i++) {
						// 						int empId = scheduleList.get(i).getEmp_id();
						int id = scheduleList.get(i).getId();
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
				<div class="row">
					<div class="col-4">
						<button type="submit">
							<a href="index.html">Back</a>
						</button>
					</div>
					<div class="col-4">
						<form action="requestServlet" method="post">
						<%if(empManager.getReqDuty(emp_id) == 0){ %>
							<button type="submit" name="requestDuty" value="1">Request
								Duty</button>
							<input type="hidden" name="empId" value="<%=emp_id%>"></input>
						<%} %>
						</form>
					</div>
					<div class="col-4">
						<form action="requestServlet" method="post">
						<%if(empManager.getReqLeave(emp_id) == 0){ %>
							<button type="submit" name="requestLeave" value="1">Request
								Leave</button>
							<input type="hidden" name="empId" value="<%=emp_id%>"></input>
							<%}%>
						</form>
					</div>
				</div>
			</div>
			<h2>Salary: <%=salary%></h2>
			<!-- Optional JavaScript; choose one of the two! -->

			<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
			<script
				src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
				integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
				crossorigin="anonymous"></script>
			<script
				src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
				crossorigin="anonymous"></script>

			<!-- Option 2: Separate Popper and Bootstrap JS -->
			<!--
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    -->
</body>
</html>