

<html>
<head>
<jsp:include page="include.jsp" />
<link rel="stylesheet" href="/style.css" type="text/css"></link>

</head>
<body>
    <h1>Admin Console</h1>
    
    <div id="usefulLinks">
    
      <ul>
        <li>
           <a href="/_ah/admin/" target="_blank">Database Admin Console</a>
        </li>
      </ul>
       <form id="createForm" name="input" action="/simple-admin/createTestData" method="post" enctype="multipart/form-data">
      <ul>
        <li>
         
			 
             <span>Upload Test Data CSV file</span>
        </li>
        <li>
           <select name = "type">
             <option value=></option>
           </select>
        </li>
        <li>
             
             <input type="file" name="file" id="file"/>
             <input type="button" name="buttonCreate" value="Create Test Data" onclick="document.getElementById('createForm').submit()"/>
     
        </li>
      </ul>
            </form>
    
    </div>
	<div id="createUser">
	  <h2>Create Consultant</h2>
		<form name="input" action="/simple-admin/save" method="post">

			<ul>
				<li><label><span>First Name</span></label> <input type="text" id="firstName"
					name="firstName" /></li>
				<li><label><span>Last Name</span></label><input type="text" id="lastName"
					name="lastName" />
				</li>
				<li><label><span>User Id</span></label> <input type="text" id="userId"
					name="userId" />
				</li>
				<li><label><span>Last Name</span></label><input type="text" id="middleName"
					name="middleName" />
				</li>
				<li><label><span>Company Id</span></label> <input type="text" id="companyId"
					name="companyId" />
				</li>
				<li><label><span>Company Type</span></label> <input type="text"
					id="companyType" />
				</li>

			</ul>
			
			<input type="submit" name="submit" value="Create Consultant"/>


			<b> <c:out value="${model.message}"/> </b>

		</form>
	</div>
</body>
</html>