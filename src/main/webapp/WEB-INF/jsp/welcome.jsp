<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

</head>
<body>
<body>

	
	<jsp:include page="header.jsp"></jsp:include>


	<div class="container mt-4">

		<div class="row">

			<div class="col-md-9">
				<div class="card mb-3">
					<div class="card-header">
						<h5 class="card-title text-center">Account list</h5>
					</div>
					<div class="card-body">

						<table class="table table-hover table-bordered">
							<thead>
								<tr>
									<th scope="col">id</th>
									<th scope="col">Fistname</th>
									<th scope="col">Lastname</th>
									<th scope="col">Email</th>
									<th scope="col">Profil</th>
									<th scope="col">State</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${accounts}" var="account">
									<tr>
										<th scope="row">${account.id}</th>
										<td>${account.firstname}</td>
										<td>${account.lastname}</td>
										<td>${account.email}</td>
										<td>${account.profil}</td>
										
										<c:if test="${account.state == true }">
											<td><span class="badge text-bg-success"
												style="background-color: green">activated</span></td>
										</c:if>
										
										<c:if test="${account.state == false }">
											<td><span class="badge text-bg-danger"
												style="background-color: red">deactivated</span></td>
										</c:if>
										<%-- <td>${account.state}</td> --%>
										
										<td>
											<c:if test="${account.state == false }">
												<a
													href="admin?action=deactivate&id=<c:out value='${account.id}' />"><button
														type="button" class="btn btn-success">activate</button></a>
											</c:if> <c:if test="${account.state == true }">
												<a
													href="admin?action=deactivate&id=<c:out value='${account.id}'/>"><button
														type="button" class="btn btn-secondary">deactivate</button></a>
												<a
													href="welcome?showForm=ok&id=<c:out value='${account.id}' />"><button
														type="button" class="btn btn-warning">update</button></a>
												<a
													href="admin?action=delete&id=<c:out value='${account.id}' />"><button
														type="button" class="btn btn-danger">delete</button></a></td>
									</tr>
									</c:if>

								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<c:set var="action" value="${action}" />
				<c:if test="${showForm == 'ok' }">
					<div class="card mb-3">
						<div class="card-header">
							<h5 class="card-title text-center">Update account</h5>
						</div>
						<div class="card-body mb-4">
							<form action="welcome" method="post">
								<div class="mb-3">
									<input type="hidden" class="form-control" name="id"
										value="<c:out value='${account.id}' />"
										id="exampleInputEmail1" aria-describedby="emailHelp">

									<input type="hidden" class="form-control" name="profil"
										value="<c:out value='${account.profil}' />"
										id="exampleInputEmail1" aria-describedby="emailHelp">

									<label for="exampleInputEmail1" class="form-label">Fistname
										address</label> <input type="text" class="form-control"
										name="firstname"
										value="<c:out value='${account.firstname}' />"
										id="exampleInputEmail1" aria-describedby="emailHelp">

									<label for="exampleInputEmail1" class="form-label">Lastname
										address</label> <input type="text" class="form-control"
										name="lastname" value="<c:out value='${account.lastname}' />"
										id="exampleInputEmail1" aria-describedby="emailHelp">

									<label for="exampleInputEmail1" class="form-label">Email
										address</label> <input type="email" class="form-control" name="email"
										value="<c:out value='${account.email}' />"
										id="exampleInputEmail1" aria-describedby="emailHelp">

								</div>
								<div class="mb-3">
									<label for="exampleInputPassword1" name="password"
										class="form-label">Password</label> <input type="password"
										name="password" value="<c:out value='${account.password}' />"
										class="form-control" id="exampleInputPassword1">
								</div>
								<button type="submit" class="btn btn-warning">Update</button>
							</form>
						</div>
					</div>

				</c:if>
			</div>

		</div>
	</div>
</body>
</html>