# EcoMovie - The Movie DB API 클론 코딩

## 링크
- [ERD](https://www.erdcloud.com/d/hc2X7xpjGho2eFv4X)
- API 문서

## 환경설정
1. 실행 전 mysql 관련 환경변수 설정
- SPRING_DATASOURCE_URL
  - 예시 : jdbc:mysql://127.0.0.1:3306/ecomovie?serverTimezone=UTC&characterEncoding=UTF-8
- SPRING_DATASOURCE_USERNAME
  - 예시 : ecomovie
- SPRING_DATASOURCE_PASSWORD
  - 예시 : ecomovie12

## 구현 계획
1. DB 구조 설계 및 샘플 데이터 추가
   1. ERD 작성
   2. DDL 작성
   3. 샘플 데이터 구성
      1. 원본 json을 가공하는 python script 작성
      2. insert sql 파일 생성
2. 상세 API 구현
   1. 엔티티 매핑
   2. QueryDSL 설정
   3. Controller, Service, Repository 구현
   4. 테스트 코드 작성
   5. Swagger 설정
   6. CORS 확인
3. 추천 API 구현
4. 번역 (Google Translate API)
5. append_to_response

## 샘플 데이터 출처
- [Kaggle TMDB sample data](https://www.kaggle.com/datasets/edgartanaka1/tmdb-movies-and-series)

## 아쉬운 점
- tmdb는 imdb와 데이터를 연결할 수 있도록 imdb_id 값을 저장하고 있다. 데이터를 가져올 때 tmdb_id라는 칼럼을 만들어 저장했으면 상호 참조할 때 더 좋을 것 같다.
