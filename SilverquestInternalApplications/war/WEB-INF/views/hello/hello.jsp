<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false"%>

<html>

<body>
    <h1>Hello - Spring Application</h1>
	<p>Greetings, it is now <c:out value="${model.now}"/></p>
	
	
	<form name="input" action="/hello/save" method="post">
		First Name: <input type="text" name="firstName" id="firstName"/><br>
		Last Name: <input type="text" name="lastName" id="lastName" /><br>
			   	  <input type="submit" value="Submit" />
	</form> 
	
  </body>

</html>