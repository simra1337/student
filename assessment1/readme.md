APIs for CRUD Operations :

1. API to create new user ,
   URL : http://localhost:8080/create ,
   METHOD : POST ,
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

2. API to list all users ,
   URL : http://localhost:8080/list-users ,
   METHOD : GET
   
3. API to update existing user ,
   URL : http://localhost:8080/update/{id} ,
   METHOD : PUT
   {
   "firstName" : "Vishnu"
   "lastName"  : "Soni"
   }

4. API to delete user using id , 
   URL : http://localhost:8080/delete/{id}
   METHOD : DELETE

5. API to add different address of existing user :
   http://localhost:8080/add-address/{id}
   METHOD : POST


API to list details of user with same name :

1. http://localhost:8080/{name}
   METHOD : GET
