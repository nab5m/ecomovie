# [GET] Movie Detail - LanguageKoKr

## Request
curl --request GET \
     --url 'https://api.themoviedb.org/3/movie/575264-mission-impossible-dead-reckoning-part-one?language=ko-Kr' \
     --header 'Authorization: Bearer <b>AccessToken</b>' \
     --header 'accept: application/json'

## Response
HttpStatusCode: 200
```json
{
  "adult": false,
  "backdrop_path": "/628Dep6AxEtDxjZoGP78TsOxYbK.jpg",
  "belongs_to_collection": {
    "id": 87359,
    "name": "미션 임파서블 시리즈",
    "poster_path": "/geEjCGfdmRAA1skBPwojcdvnZ8A.jpg",
    "backdrop_path": "/jYl0UuJFcmhymv9ZNO14lPLDY1Z.jpg"
  },
  "budget": 291000000,
  "genres": [
    {
      "id": 28,
      "name": "액션"
    },
    {
      "id": 53,
      "name": "스릴러"
    }
  ],
  "homepage": "",
  "id": 575264,
  "imdb_id": "tt9603212",
  "original_language": "en",
  "original_title": "Mission: Impossible - Dead Reckoning Part One",
  "overview": "모든 인류를 위협할 새로운 무기를 추적하게 된 에단 헌트와 IMF팀은 이 무기가 인류의 미래를 통제할 수 있다는 사실을 알게 된다. 전 세계가 위태로운 상황에 처한 가운데, 이를 추적하던 에단 헌트에게 어둠의 세력까지 접근하고 마침내 미스터리하고 강력한 빌런과 마주하게 된 그는 가장 위험한 작전을 앞두고 자신이 아끼는 사람들의 생명과 중요한 임무 사이에서 선택을 해야 하는 상황에 놓이게 되는데…",
  "popularity": 4961.526,
  "poster_path": "/nQsWPG020kSWdOl3EhFXRNE2s0n.jpg",
  "production_companies": [
    {
      "id": 4,
      "logo_path": "/gz66EfNoYPqHTYI4q9UEN4CbHRc.png",
      "name": "Paramount",
      "origin_country": "US"
    },
    {
      "id": 82819,
      "logo_path": "/gXfFl9pRPaoaq14jybEn1pHeldr.png",
      "name": "Skydance",
      "origin_country": "US"
    },
    {
      "id": 21777,
      "logo_path": null,
      "name": "TC Productions",
      "origin_country": "US"
    }
  ],
  "production_countries": [
    {
      "iso_3166_1": "US",
      "name": "United States of America"
    }
  ],
  "release_date": "2023-07-08",
  "revenue": 567148955,
  "runtime": 164,
  "spoken_languages": [
    {
      "english_name": "French",
      "iso_639_1": "fr",
      "name": "Français"
    },
    {
      "english_name": "English",
      "iso_639_1": "en",
      "name": "English"
    },
    {
      "english_name": "Italian",
      "iso_639_1": "it",
      "name": "Italiano"
    },
    {
      "english_name": "Russian",
      "iso_639_1": "ru",
      "name": "Pусский"
    }
  ],
  "status": "Released",
  "tagline": "가장 위험한 작전, 그의 마지막 선택",
  "title": "미션 임파서블: 데드 레코닝 PART ONE",
  "video": false,
  "vote_average": 7.7,
  "vote_count": 1586
}
```