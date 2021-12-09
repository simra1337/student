APIs for CRUD Operations :

1. API to create new user ,
   URL : http://localhost:9091/create ,
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
   URL : http://localhost:9091/list-users ,
   METHOD : GET

3. API to find user by ID ,
   URL : http://localhost:9091/user/{id}
   METHOD : GET

4. API to update existing user ,
   URL : http://localhost:9091/update/{id} ,
   METHOD : PUT
   {
   "firstName" : "Vishnu"
   "lastName"  : "Soni"
   }

5. API to delete user using id , 
   URL : http://localhost:9091/delete/{id}
   METHOD : DELETE

6. API to delete all users , 
   URL : http://localhost:9091/delete-all
   METHOD : DELETE

7. API to add different address of existing user :
   http://localhost:9091/add-address/{id}
   METHOD : POST


API to list details of user with same name :

1. http://localhost:9091/{name}
   METHOD : GET
