<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false"%>




<html>
<head>
  <link rel="stylesheet" href="/style.css" type="text/css"></link>
</head>
<body>
	<h1>Time Sheets Screen</h1>


	<div class="CREATE">
		<form name="input" action="/timesheets/createNewTimeSheet.htm"
			method="post">

			<h2>Create timesheet</h2>
			<ul>
			
				<li><label><span>Start date</span>
				</label> <input type="text" id="weekStarting" name="weekStarting" /></li>

				<li><label><span>Consultant userId</span>
				</label> <select name="owner">
						<c:forEach var="item" items="${model.consultants}">

							<option value="${item.id}">
								<c:out value="${item.firstName}" />
								-
								<c:out value="${item.lastName}" />
							</option>
						</c:forEach>
				</select></li>
				<li><label><span>ContractId</span></label><input type="text"
					name="assignmentId"> <input type="hidden" name="status"
					value="NEW" /></li>


			</ul>
			<table border="1">

				<tr>
					<th>Date</th>
					<th>Hours</th>
					<th>Portion of day</th>
				</tr>

				<c:forEach items="${model.timeSheetEntries}" var="i"
					varStatus="itemsRow">
					<tr>
						<td><input type="text"
							name="timeSheetEntries[${itemsRow.index}].date" /></td>
						<td><input type="text"
							name="timeSheetEntries[${itemsRow.index}].numberOfHours" /></td>
						<td><input type="text"
							name="timeSheetEntries[${itemsRow.index}].portionOfDay" /></td>
					</tr>
				</c:forEach>

			</table>
			<input type="submit" name="submit" value="Create Timesheet" />

		</form>
	</div>

</body>
</html>
