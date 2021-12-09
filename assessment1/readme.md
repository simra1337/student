APIs for CRUD Operations :

1. http://localhost:8080/create
   METHOD : POST
   sample data :
   { 
   "firstName" : "Mohd",
   "lastName" : "Simra",
   "course" : "MCA",
   "contact" : "7455990850",
   "country" : "India",
   "state" : "Up",
   "city" : "Bijnor",
   "addressLine" : "Near Post Office",
   "zipCode" : "246763",
   "fatherName" : "Mohd",
   "motherName" : "Hashim",
   "hometownCity" : "Delhi"
   }

2. http://localhost:8080/list-users
   METHOD : GET
   
3. http://localhost:8080/update/{id}
   METHOD : PUT
   {
   "firstName" : "Vishnu"
   "lastName"  : "Soni"
   }

4. http://localhost:8080/delete/{id}
   METHOD : DELETE


API to list details of user with same name :

1. http://localhost:8080/{name}
   METHOD : GET
