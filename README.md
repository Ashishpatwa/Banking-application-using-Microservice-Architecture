
I am using Mysql database as a  accountMicroservice and customerMicroservice for Account and Customer microservices respectively. 


## Service Registory port Number:- 8761 
## Config-Server port Number:- 9093 
## Api-Gateway port Number:- 9092 
## Account-Service port number:- 9090 
## Customer-Service port number:- 9091 

 

# API END-POINTS 

## For creating customer [POST] 

 http://localhost:9092/api/customer/add-customer 

 

{ 

    "customerName" : "Vaishnavi", 

    "gmail": "Vaishnavi04@gmail.com", 

    "phnNo": 6306889952, 

    "address": "7/97 Sita Ram Colony", 

    "pincode": 205781, 

    "dateOfBirth": "2004-04-02" 

} 

 

# Get All Customer Details [GET] 

 http://localhost:9092/api/customer/get-all-customers 

 

# Get Specific Customer Details [GET] 

 http://localhost:9092/api/customer/get-customer/[CustomerId] 

 

# Update Customer [PUT] 

http://localhost:9092/api/customer/update-customer/[CustomerId] 

 

{ 

    "customerName" : "Vaishnavi-Patwa", 

    "gmail": "Vaishnavi04@gmail.com", 

    "phnNo": 6306889952, 

    "address": "7/97 Sita Ram Colony", 

    "pincode": 205781, 

    "dateOfBirth": "2004-04-02" 

} 

 

 

# Create Account [POST] 

http://localhost:9092/api/account/create-account/[CustomerId] 

 

{ 

    "accountType": "Saving-Account", 

    "balance": 2000.0, 

    "rateOfInterest": 6.25, 

    "userPin": 786001    

} 

 

 

 

# Add Amount [PUT] 

http://localhost:9092/api/account/add-amount/[CustomerId]/[AccountNumber]/[UserPin]/[Amount] 

 

# Withdraw Amount [PUT] 

http://localhost:9092/api/account/withdraw-amount/[CustomerId]/[AccountNumber]/[UserPin]/[Amount] 

 

# Get Account details [GET] 

http://localhost:9092/api/account/get-details/[CustomerId]/[AccountNumber] 

 
# Delete Customer with Account Details [DELETE] 

http://localhost:9092/api/customer/delete-customer/[CustomerId] 

 
# Delete Account Details [DELETE] 

http://localhost:9092/api/account/delete-account/[CustomerId]/[AccountNumber] 

 
# Get all account of customer [GET] 

http://localhost:9092/api/account/get-accounts-of-customer/[CustomerId] 
