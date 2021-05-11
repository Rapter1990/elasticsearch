# Spring Boot and Elastic Search via Docker

<img src="screenshots\elasticsearch_springboot.PNG" alt="Main Information" width="800" height="300">

### 📖 Information

<ul style="list-style-type:disc">
  <li>We can search full-text in a huge data stack via <b>Elastic Search</b>.</li>
  <li>By searching through indexes, it produces the result quickly </li>
  <li>Here is the explanation of the project
      <ul>
        <li>After implementing Elastic Search configuration, the projects provides you to implement both CRUD process and custom search criteria operations</li>
      </ul>
  </li>
</ul>

### 🔨 Run the App

<b>1 )</b> Install <b>Docker Desktop</b>. Here is the installation <b>link</b> : https://docs.docker.com/docker-for-windows/install/

<b>2 )</b> Open <b>Terminal</b> under <b>resources</b> folder to run <b>Elastic Search Server</b> on <b>Docker</b> Container
```
    docker-compose up -d
```

<b>3 )</b> Show <b>container</b> which runs on <b>Docker</b>
```
    docker ps
```

<b>4 )</b> To save movie, write url and movie body shown below
```
http://localhost:8080/movies/save

movie body

{
    "name": "MovieA",
    "genre": [
        { "name" : "Comedy"},
        { "name" : "Action"}
    ],
    "rating" : "8.5",
    "director" : {
            "name" : "Director 1"
        }
}
```
<b>5 )</b> To get all movie list, write url shown below.
```
http://localhost:8080/movies/find/all
```

<b>6 )</b> To get any specific movie, write url shown below
```
http://localhost:8080/movies/find/{movie_id}
```

<b>7 )</b> To search any specific movie, write url shown below
```
http://localhost:8080/movies/{movie_name}
```

<b>8 )</b> To search any specific movie with <b>fuzziness</b>, write url shown below. Fuzziness means that you can write any text which defines its search format like <b>MovIE(Movie)</b> before implementing its process.
```
http://localhost:8080/fuzzines/{movie_name}
```

<b>9 )</b> To search any specific movie by its <b>id</b> or <b>name</b>,write url shown below. 
```
http://localhost:8080/multi/{movie_id}
http://localhost:8080/multi/{movie_name}
```

<b>10 )</b> To search any specific movie by full text movie name like ,write url shown below. 
```
http://localhost:8080/multi/{movie_id}
http://localhost:8080/multi/{movie_name}
```

<b>11 )</b> To search any specific movie by phrase ,write url shown below. 
```
http://localhost:8080/phrase_search/{movie_name}
```

<b>12 )</b> To search any specific movie by phrase ,write url shown below. 
```
http://localhost:8080/phrase_search/{movie_name}
```

<b>13 )</b> To search any specific movie by name, write url shown below
```
http://localhost:8080/find_name/{movie_name}
```

<b>14 )</b> To search any specific movie by rating between two value, write url shown below
```
http://localhost:8080/getByRatingInterval/start/{start}/end/{end}
```

<b>15 )</b> To search any specific movie by director, write url shown below
```
http://localhost:8080/finddirector/{movie_name}
```

<b>16 )</b> To search any specific movie by director, write url shown below
```
http://localhost:8080/finddirector/{movie_name}
```

<b>17 )</b> To update any specific movie by id, write url shown below and write the request body
```
http://localhost:8080/update/{movie_id}

{
    "name": "MovieB",
    "genre": [
        { "name" : "Drama"},
        { "name" : "Action"}
    ],
    "rating" : "8.8",
    "director" : {
            "name" : "DirectorB"
        }
}
```

<b>18 )</b> To delete any specific movie by id, write url shown below
```
http://localhost:8080/movies/delete/{movie_id}
```

### Screenshots

<details>
<summary>Click here to show the screenshots of project</summary>
    <p> Figure 1 </p>
    <img src ="screenshots\elasticsearch_1.PNG">
    <p> Figure 2 </p>
    <img src ="screenshots\elasticsearch_2.PNG">
    <p> Figure 3 </p>
    <img src ="screenshots\elasticsearch_3.PNG">
    <p> Figure 4 </p>
    <img src ="screenshots\elasticsearch_4.PNG">
    <p> Figure 5 </p>
    <img src ="screenshots\elasticsearch_5.PNG">
    <p> Figure 6 </p>
    <img src ="screenshots\elasticsearch_6.PNG">
    <p> Figure 7 </p>
    <img src ="screenshots\elasticsearch_7.PNG">
    <p> Figure 8 </p>
    <img src ="screenshots\elasticsearch_8.PNG">
    <p> Figure 9 </p>
    <img src ="screenshots\elasticsearch_9.PNG">
    <p> Figure 10 </p>
    <img src ="screenshots\elasticsearch_10.PNG">
    <p> Figure 11 </p>
    <img src ="screenshots\elasticsearch_11.PNG">
    <p> Figure 12 </p>
    <img src ="screenshots\elasticsearch_12.PNG">
    <p> Figure 13 </p>
    <img src ="screenshots\elasticsearch_13.PNG">
    <p> Figure 14 </p>
    <img src ="screenshots\elasticsearch_14.PNG">
</details>