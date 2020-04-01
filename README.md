# Microservices-Kubernetes-Deployment
Deploy microservices to Kubernetes Cluster (on Google Kubernetes Engine)

The purpose of this project is to create working REST microservices which will be deployed to Kubernetes cluster (on Google Kubernetes Engine) using docker images.

· Consists 3 microservices in Spring Boot Java

o User Service – Will provide a REST endpoint giving details of user (it should return your name and email id, no need to integrate any database or logic)

§ GET /user/1

{

"name": "John",

"age": "23",

"email": "john.doe@google.com"

}

o Orders Service – Will give a list of all orders of a user. (it should return a predefined list, no database needed)

§ GET /orders/1

{

"orders": [

{

"orderId": 1,

"orderAmount": 250,

"orderDate": "14-Apr-2020"

},

{

"orderId": 2,

"orderAmount": 450,

"orderDate": "15-Apr-2020"

}

]

}

o Aggregator Service – Will aggregate the response from user and orders service to give following response (should get data from user and order service’s rest endpoint)

§ GET /orderdetails/1

{

"userDetails": {

"name": "John",

"age": "23",

"email": "john.doe@google.com"

},

"orders": [

{

"orderId": 1,

"orderAmount": 250,

"orderDate": "14-Apr-2020"

},

{

"orderId": 2,

"orderAmount": 450,

"orderDate": "15-Apr-2020"

}

]

}

· Build and push docker images to dockerhub for all the microservices.

   Build image : docker build -t imagename:tagname .
   Tag image with dockerhub username : docker tag imagename:tagname mansi17/imagename:tagname
   Push image : docker push mansi17/imagename:tagname

· Create a Google Kubernetes engine cluster on GKE

· Deploy all the 3 microservices on GKE using separate YAML files for each deployment as given in each microservice folder.

  Upload file using google cloud shell UI - 
  Type command : kubectl apply -f deployment.yml  (deployment.yml is the name of deployment file)
  To see if the pods are created : kubectl get pods
  To see if there is an error or deployment information : kubectl describe deployment user-deployment

· Expose the services in following manner:-

o Expose only Aggregator microservice externally to the internet

o User and Order service should be exposed only internally using Cluster IP and both should be consumed internally by the Aggregator microservice.
