# 2024-WithSnow-server

# 개발환경
1. IDE: IntelliJ IDEA Community
2. Spring Boot 3.2.7
3. Java 17
4. H2
5. mySQL

# 탐색 주요 기능
1. 지도 불러오기(/maps)
2. 경로 검색하기(/maps/{start}/{end})
3. 장소 검색하기(/maps/{place_id})

# 커뮤니티 주요 기능
1. 전체 게시글 조회(/posts)
2. 게시글 추가(/posts)
3. 게시글 삭제(/posts/{post_id})

# 복지사 주요 기능
1. 지자체 복지사 전체 조회(/welfares)
2. 호출 복지사 리스트 조회(/welfares/{welfare_id})
3. 매칭 복지사 전송(/welfares)
4. 복지사 상태 업데이트(/welfares/{call_id})

# 즐겨찾기 주요 기능
1. 즐겨찾기 저장(/bookmarks/{member_id})
2. 즐겨찾기 조회(/bookmarks/{member_id})