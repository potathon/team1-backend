# 해커톤 - 데일리 면접 플랫폼
## 개요
- tts와 stt, chat gpt 토큰을 활용한 면접 플랫폼

**제작 목적**
- 구직자의 면접 준비를 돕기 위한 플랫폼
- 제출된 답변을 음성에서 문자로, 문자에서 음성으로 변환하여 db에 저장
- 변환한 문자열을 chat gpt에 제출하여 평가를 받을 수 있음
  
**일정**
- 2024년 7월 13일 09시 - 2024년 7월 14일 10시
  
**역할**
- 백엔드 컨트롤러 개발 및 서비스 개발

## 사용 기술 및 개발 환경
- Language : Java, JavaScript
- Web server : Ningx
- Framework : Spring boot,Flask
- DB : MariaDB
- CI/CD : Jenkins
- API : Github token
- Tool : Github

## 구현 기능
**데일리 페이지**
- 매일 3개의 질문이 데일리로 설정됨
- 각 문제에 답변하며 타이머가 바 게이지로 나타나고, 타이머가 끝나면 다음 질문으로 넘어감
- 녹음된 답변을 텍스트로 변호나하고, 사용자가 이를 수정하여 최종 답변을 올릴 수 있음

  **음성-텍스트 전환 서비스**
  - 질문을 tts를 사용해 읽어주는 기능을 제공함
  - 응답을 stt를 사용해 문자로 변환하는 기능을 제공함
 
  **AI 기반 답변 피드백 서비스**
  - 제출한 응답을 바탕으로 OpenAI api를 사용하여 피드백을 제공함

## 개발 과정
![스크린샷 2024-07-17 101148](https://github.com/user-attachments/assets/2b824394-f63b-4e45-8e63-498ac4b32cc3)

## API 명세서
![스크린샷 2024-07-17 101127](https://github.com/user-attachments/assets/3213b85f-1dbb-4f07-847e-ac5d2ffe5751)

 ## ER Diagram
![스크린샷 2024-07-17 101119](https://github.com/user-attachments/assets/98f054aa-ff35-4129-a0f4-5996ec95f249)

## 아키텍쳐 설계도
![스크린샷 2024-07-17 101138](https://github.com/user-attachments/assets/e6b36d63-8289-4635-8ed2-db5799cad85e)

## 배포 사이트
- https://goldenteam.site/


