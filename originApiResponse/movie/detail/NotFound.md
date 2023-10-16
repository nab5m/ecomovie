# [GET] Movie Detail - NotFound

## Request
curl --request GET \
--url https://api.themoviedb.org/3/movie/movie_id \
--header 'Authorization: Bearer <b>AccessToken</b>' \
--header 'accept: application/json'

## Response
HttpStatusCode: 404
```json
{
  "success": false,
  "status_code": 34,
  "status_message": "The resource you requested could not be found."
}
```