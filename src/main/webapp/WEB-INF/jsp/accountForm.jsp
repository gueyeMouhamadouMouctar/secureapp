<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<div style="width: 600px; margin: auto;">

			<div class="card mt-4 ">
				<div class="card-header">
					<h5 class="card-title text-center text-uppercase">New account</h5>
				</div>
				<div class="card-body mb-4">
					<form action="signup" method="post">
						<div class="mb-3">
							<input type="hidden" class="form-control" name="id"
								id="exampleInputEmail1" aria-describedby="emailHelp"> <input
								type="hidden" class="form-control" name="profil"
								id="exampleInputEmail1" aria-describedby="emailHelp"> <label
								for="exampleInputEmail1" class="form-label">Fistname
								</label> <input type="text" class="form-control"
								name="firstname" id="exampleInputEmail1"
								aria-describedby="emailHelp"> <label
								for="exampleInputEmail1" class="form-label">Lastname
								</label> <input type="text" class="form-control" name="lastname"
								id="exampleInputEmail1" aria-describedby="emailHelp"> <label
								for="exampleInputEmail1" class="form-label">Email
								address</label> <input type="email" class="form-control" name="email" 
								id="exampleInputEmail1" aria-describedby="emailHelp">

						</div>
						<div class="mb-3">
							<label for="exampleInputPassword1" name="password"
								class="form-label">Password</label> <input type="password"
								name="password" class="form-control"
								id="exampleInputPassword1">
						</div>
						<div class="mb-3">
							<label for="exampleInputPassword1" name="confirmPassword"
								class="form-label">Confirm password</label> <input type="password"
								name="confirmPassword" class="form-control"
								id="exampleInputPassword1">
						</div>
						<div class="">
							<button type="submit" class="btn btn-success">Save
							account</button>
						</div>
					</form>
				</div>
			</div>

		</div>
	</div>
</body>
</html>