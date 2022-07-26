UrlHashing
================================
REST Api using SpringBoot and MySQL that returns a shortened version of given URL and convert that back

# Getting Started
## Build
```
git clone https://github.com/tomar-sumit108/UrlHashing.git
cd UrlHashing
gradle clean build

```
## Deployment
```
docker-compose up --build
```
This uses the `db.Dockerfile` and `spring.Dockerfile` for MySql and SpringBoot application respectively and exposes port `8080`.</br> 
`docker-compose.yml` file is the configuration file which sets up two service under container names `urlhashing` and `dbcontainer` which are linked together.</br.

### Running Directly without Docker
1. Start MySQL server on `port 3306` and create database with name `UrlHashingDb`
2. Import the `databaseSchema.sql` file in above database
3. Run the Jar file under build/libs 

## API Endpoints
POST `/v1/save`
It takes json in the format
```
{
  "url" : "{url to be hashed}"
}
```
Response
```
{
  "url" : "{short url}"
}
```

GET `v1/{short url}`
It will redirect to the fullUrl.


# Url Shortening Algorithm
- I have used Base62 Encoding:- Here I first MySql auto-generated a integer key for each url, now generally programming languages can store 64 bit integer easily i.e about 10^18. 
- Then I converted that key to a Base62 code to store 10^18 code it would take about 9 characters to store.
- So first Large Url is converted to Base10 code(max 18 chars as 10^18) then to Base62 code(max 9 chars) which significantly reduced the length of URL.
- Now coming to 10^18 number let say we have 10,000/Sec request then it would take about 3 Million years to exhaust all these code. Phew!

# Further Enhancements
- Here I used RDBMS when it comes to scaling its a bit complex, it that case NoSQL comes into picture but it has the consistency issue.
- Now my algorithm works will work well with one server but when it comes to multiple servers they may be same unique id generated for different request.
- To overcome these problems one solution can be to store seperate generator for each server and each having its own limit but in this case I think some kind of manager would be required to manage all servers

# TODOS
- Unit Test Cases
- More validation can be implemented for url
- UI implementation may be android application






 
