# [GET] Movie Detail - Unauthorized

## Request
curl --request GET \
--url https://api.themoviedb.org/3/movie/movie_id \
--header 'accept: application/json'

## Response
HttpStatusCode: 401
```json
{
  "status_code": 7,
  "status_message": "Invalid API key: You must be granted a valid key.",
  "success": false
}
```