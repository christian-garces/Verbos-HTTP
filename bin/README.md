# Spring & MongoDB Rest API (Http verbs) 
  Project URL
  - http://localhost:8080/film/

### GET /getAllFilms 

- Retrieves data from the server. It's safe and idempotent, meaning it should not modify server state and multiple identical requests should have the same effect as a single request.

### POST /createFilm  

- Submits data to the server to create a new resource. It's not idempotent, meaning multiple identical requests may have different effects each time.
```bash
{
    "title": "Deadpool",
    "producer": "Marvel",
    "duration": "1h 48min",
    "genre": "Action/Comedy"
}
```

### PUT /updateFilm

- Updates an existing resource on the server. It's idempotent, meaning multiple identical requests will have the same effect as a single request.
```bash
{
    "id": "661c787e10aa9918ca0cb5fd",
    "title": "Deadpool",
    "producer": "Marvel Entertainment.",
    "duration": "1h 48min",
    "genre": "Action/Comedy"
}
```

### PATCH /patchFilm/{id}

- Partially updates an existing resource. It's generally used when you want to apply a partial update to a resource.
```bash
{
    "id": "661c787e10aa9918ca0cb5fd",
    "title": "Deadpool",
    "producer": "Marvel Entertainment.",
    "duration": "1h 48min",
    "genre": "Comedy"
}
```

### DELETE /deleteFilm/{id}

- Removes a resource from the server.
  

### HEAD /getFilmHeaders/{id}

- Retrieves the headers of a resource without the body. It's typically used to check for the existence of a resource or to obtain metadata about a resource.


### OPTIONS /options

- Returns the HTTP methods that the server supports for a specified URL. It's often used to determine the capabilities of the server at a given URL.

