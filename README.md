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
3. 추천 API 구현
4. 번역 (Google Translate API)
5. append_to_response

## 샘플 데이터 출처
- [Kaggle TMDB sample data](https://www.kaggle.com/datasets/edgartanaka1/tmdb-movies-and-series)
