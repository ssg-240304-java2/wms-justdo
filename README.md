# :strawberry:FruitFruit:strawberry:
## 프로젝트 소개
- 과일 거래 중개 플랫폼
- 판매자와 구매자의 직접 거래가 가능하도록 중개 해주는 플랫폼입니다.
- 판매자는 플랫폼에서 소유하고 있는 창고에 수확한 과일을 보내면 창고에서 품질 관리 및 배송 대행까지 진행한다.
- 구매자는 적은 지출로 고품질의 상품을 판매 할 수 있도록 한다.

## 팀원 구성
<div align="center">

| 이은솔 | 박진수 | 안준렬 | 이정훈 | 장준영 | 
| :------: |  :------: | :------: | :------: | :------: |
|[<img width="98" alt="스크린샷 2024-05-21 오후 4 38 10" src="https://github.com/ssg-240304-java2/wms-justdo/assets/162261450/741ac829-cdf9-48af-a245-a39839e008a3"> <br> @lucinda96](https://github.com/lucinda96)|[<img width="84" alt="스크린샷 2024-05-21 오후 4 38 15" src="https://github.com/ssg-240304-java2/wms-justdo/assets/162261450/8947bf53-2dad-44d4-b77c-6a002f615d02"> <br> @ptecc208](https://github.com/ptecc208)|[<img width="99" alt="스크린샷 2024-05-21 오후 4 38 21" src="https://github.com/ssg-240304-java2/wms-justdo/assets/162261450/648f0430-682a-459b-8af5-76dae511a31c"> <br>@JunRyeol98](https://github.com/JunRyeol98)|[<img width="63" alt="스크린샷 2024-05-21 오후 4 38 25" src="https://github.com/ssg-240304-java2/wms-justdo/assets/162261450/cd4fa5b3-2194-44fe-9189-dbfb67798286"> <br>@leejeonghun99](https://github.com/leejeonghun99)|[<img width="98" alt="스크린샷 2024-05-21 오후 4 38 31" src="https://github.com/ssg-240304-java2/wms-justdo/assets/162261450/43017dc9-0b98-4c5d-a52f-b768a7506e53"> <br>@finite2030](https://github.com/finite2030)| 

</div>

## 1. 개발 환경

- JDK : JAVA 17
- DB: MySQL 8.3.0
- IDE : IntelliJ IDEA Ultimate 2023.3.6
### Dependency

- JDBC 8.0.28
- Lombok 1.18.24
- Mybatis 3.5.6

## 2. 개발 기간 및 작업 관리
- 2024-05-17 ~ 2024-05-21

## 3. 작업 관리 
- GitHub Projects와 Issues를 사용하여 진행 상황을 공유했습니다.

## 4. 작업구조
~~~
└─src
    └─main
        ├─java
        │  └─com
        │      └─justdo
        │          └─fruitfruit
        │              ├─common
        │              │  └─constant
        │              ├─controller
        │              ├─model
        │              │  ├─dao
        │              │  ├─dto
        │              │  └─service
        │              ├─run
        │              └─view
        └─resources
            ├─config
            └─sql
                ├─seller
                ├─system
                ├─user
                └─warehouse
~~~

## 5. 역할 분담
- 이은솔 : 창고 관리자
- 박진수 : 비회원, 구매자, 판매자
- 안준렬 : 구매자
- 이정훈 : 비회원, 구매자, 판매자
- 장준영 : 시스템 관리자

## 테스트 진행
- [테스트 시나리오](https://coffit23.notion.site/e2c3690f8b364a90bad4ffd64905e65d?pvs=74)
- [테스트 케이스](https://docs.google.com/spreadsheets/d/1PyJjMtrdEniZZe4tcWN3O0nXKTNwPmEDI009XH5ZYhg/edit#gid=0)

