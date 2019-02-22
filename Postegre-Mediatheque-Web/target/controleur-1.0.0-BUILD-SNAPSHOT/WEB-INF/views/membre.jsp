<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib  uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri = "http://www.springframework.org/tags" prefix = "spring"%>
<%@ taglib  uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Membre management</title>
</head>
<body>
	<h1>Membre</h1>
	<form:form action="membre.do" method="POST" commandName="membre">

<table>
          <tr>
              <td> mail </td>
               <td> <form:input  path="mail" /></td>
          </tr>
          <tr>
              <td> mdp</td>
              <td> <form:input  path="mdp" /></td>
          </tr>
          <tr>
              <td> nom </td>
              <td> <form:input  path="nom" /></td>
          </tr>
          <tr>
              <td> Prénom: </td>
              <td> <form:input  path="prenom" /></td>
          </tr>
          <tr>
              <td> phone</td>
              <td> <form:input  path="phone" /></td>
          </tr>
          
          <tr>
              <td> sexe</td>
              <td> <form:input  path="sexe" /></td>
          </tr>
           <tr>
              <td> adresse</td>
              <td> <form:input  path="adresse" /></td>
          </tr>
          <tr>
              <td  colspan ="2" >
                  <input  type = "submit"  name="action" value = 1 />
                  <input  type = "submit"  name="action" value = 2 />
                  <input  type = "submit"  name="action" value = 3 />
                  <input  type = "submit"  name="action" value = 4 />

              </td>
          </tr>
          
      </table >

	</form:form>
	
	<br>
	<table>
		<th>mail</th>
		<th>mdp</th>
		<th>nom</th>
		<th>prenom</th>
		<th>phone</th>
		<th>sexe</th>
		<th>adresse</th>
		<c:forEach items="${membreAll}" var="membre">
			<tr>
				<td>${membre.mail}</td>
				<td>${membre.motdepasse}</td>
				<td>${membre.nom}</td>
				<td>${membre.prenom}</td>
				<td>${membre.phone}</td>
				<td>${membre.sexe}</td>
				<td>${membre.adresse}</td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>