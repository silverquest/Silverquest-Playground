<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page isELIgnored="false"%>

    <title>Account Manager</title>

    <link rel="stylesheet" type="text/css" href="/resources/ext-4.0.2a/resources/css/ext-all.css">

    <script type="text/javascript" src="/resources/ext-4.0.2a/ext-debug.js"></script>

    <script type="text/javascript" src="/resources/app/view/timegrid.js"></script>
    <script type="text/javascript" src="/resources/app/app.js"></script>

    
    <script type="text/javascript">
    
      var userName = '${model.userName}';
      var consultantFName = '${model.ConsultantFName}';
      var consultantLName = '${model.ConsultantLName}';
      var companyName = '${model.CompanyName}'; 
      var companyAddress = '${model.CompanyAddress}';
    
    </script>
    
</head>

<body></body>
</html>