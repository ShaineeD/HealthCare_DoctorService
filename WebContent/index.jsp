<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.Doctor"  %>   
    
    
<%--    <%
if (request.getParameter("itemCode") != null)
{
session.setAttribute("itemCode", request.getParameter("itemCode"));
session.setAttribute("itemName", request.getParameter("itemName"));
session.setAttribute("itemPrice", request.getParameter("itemPrice"));
session.setAttribute("itemDesc", request.getParameter("itemDesc"));
}
    
%>   --%>






<%-- 

<%


session.setAttribute("statusMsg", "");
System.out.println("Trying to process.............");


if (request.getParameter("itemCode") != null)
{
Item itemObj = new Item();
String stsMsg = "";
//Insert--------------------------
if (request.getParameter("hidItemIDSave") == "")
{
stsMsg = itemObj.insertItem(request.getParameter("itemCode"),
request.getParameter("itemName"),
request.getParameter("itemPrice"),
request.getParameter("itemDesc"));
}
else//Update----------------------
{
stsMsg = itemObj.updateItem(request.getParameter("hidItemIDSave"),
request.getParameter("itemCode"),
request.getParameter("itemName"),
request.getParameter("itemPrice"),
request.getParameter("itemDesc"));
}
session.setAttribute("statusMsg", stsMsg);
}
//Delete-----------------------------
if (request.getParameter("hidItemIDDelete") != null)
{
	Item itemObj = new Item();
String stsMsg =
itemObj.deleteItem(request.getParameter("hidItemIDDelete"));
session.setAttribute("statusMsg", stsMsg);
}


%>



--%>








    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Service</title>

<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/items.js"></script>


</head>
<body>


<div class="container">
<div class="row">
<div class="col-6">

<h1>Doctor Service</h1>
<form id="formItem" name="formItem">
Hospital ID:
<input id="hospitalID" name="hospitalID" type="text" class="form-control form-control-sm">
<br> Name:
<input id="docName" name="docName" type="text" class="form-control form-control-sm">
<br> Email:
<input id="docEmail" name="docEmail" type="text" class="form-control form-control-sm">
<br> Address:
<input id="docAddress" name="docAddress" type="text" class="form-control form-control-sm">
<br> Specialization:
<input id="specialization" name="specialization" type="text" class="form-control form-control-sm">
<br> workingTime:
<input id="workingTime" name="workingTime" type="text" class="form-control form-control-sm">
<br> workingDays:
<input id="workingDays" name="workingDays" type="text" class="form-control form-control-sm">
<br> workingHospitals:
<input id="workingHospitals" name="workingHospitals" type="text" class="form-control form-control-sm">
<br> Doctors's Fee:
<input id="docFee" name="docFee" type="text" class="form-control form-control-sm">
<br> Username:
<input id="username" name="username" type="text" class="form-control form-control-sm">
<br> Password:
<input id="password" name="password" type="text" class="form-control form-control-sm">
<br>
<input id="btnSave" name="btnSave" type="button" value="Save"
class="btn btn-primary">
<input type="hidden" id="hidDocIDSave" name="hidDocIDSave" value="">
</form>


<div id="alertSuccess" class="alert alert-success">

<%--   <%
  out.print(session.getAttribute("statusMsg"));
  
  %>  --%>


</div>

<div id="alertError" class="alert alert-danger"></div>
  
   <br>
   <div id="divItemsGrid">
   <%
   	Doctor docObj = new Doctor();
            out.print(docObj.readItems());
   %>
   </div>
   
   
   </div>
   </div>
   </div>


<br>

<%--   
<table border="1">
<tr>
<th>Item Code</th>
<th>Item Name</th>
<th>Item Price</th>
<th>Item Description</th>
<th>Update</th>
<th>Remove</th>
</tr>
<tr>
<td><%out.print(session.getAttribute("itemCode")); %></td>
<td><%out.print(session.getAttribute("itemName")); %></td>
<td><%out.print(session.getAttribute("itemPrice")); %></td>
<td><%out.print(session.getAttribute("itemDesc")); %></td>
<td><input name="btnUpdate" type="button" value="Update"></td>
<td><input name="btnRemove" type="button" value="Remove"></td>
</tr>
</table>  

--%>







</body>
</html>