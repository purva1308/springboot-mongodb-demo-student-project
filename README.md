# springboot-mongodb-demo-student-project
This project contains a spring-boot server which communicates with mongoDB for CRUD operations.

A. The "app" folder contains the source code spring-boot application which enables to get list of students with marks 90 and above in maths from grade 1 to 10 

B. The "postman-collection" folder has the REST API details 

1> First POST method API enables to insert data in mongo database : student with collection named as studentDetails
    
    http://localhost:8081/api/students/insertStudent
    Sample Request Body:
    {
    "id": "105",
    "name": "Uvw",
    "division": 4,
    "mathsScore": 98
  }
    
 2> Second is GET API that will give the list of students with marks 90 and above in maths from grade 1 to 10 
 
 http://localhost:8081/api/students/above-90-in-maths
 Sample Response :
         [
          "Pqr",
          "Uvw"
        ]

C. "dockerImages" contains the springboot and mongodb images 

D. Steps to run docker images 

1> Import the docker image from the "dockerImages" folder 
 docker load < tar-file-name-provided 
2> Check following docker images must be created by below command: student-spring-mongo , mongo 
docker images 
3> Run below command to execute the docker images for spring boot app to get connected to mongodb 
docker run -p 8081:8081 --name student-spring-mongo --link studentmongodb:mongo -d student-spring-mongo:1.0
4> Run below command to check if server is up and mongodb is connected 
docker logs student-spring-mongo

General Info:
For mongo to run have followed below steps :
1> Pulled mongo image
docker pull mongo:latest
2> created image/host studentmongodb and run it on mongo default port 
docker run -d -p 27017:27017 --name studentmongodb mongo:latest

