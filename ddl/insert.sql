use potato;

-- User 테이블에 더미 데이터 삽입
INSERT INTO user (token, name, profile) VALUES
('token1', 'Haisley', 'https://item.kakaocdn.net/do/ce07c75bbab976caf3a4671bcba2c3fa7154249a3890514a43687a85e6b6cc82'),
('token2', 'Erica', 'https://item.kakaocdn.net/do/6be700c90d59a5f40129581539501f7482f3bd8c9735553d03f6f982e10ebe70'),
('token2', 'Lucy', 'https://item.kakaocdn.net/do/9f6391218e3a68eb052a0e6bdd46e649113e2bd2b7407c8202a97d2241a96625'),
('token2', 'Kevin', 'https://item.kakaocdn.net/do/9f6391218e3a68eb052a0e6bdd46e649ac8e738cb631e72fdb9a96b36413984e'),
('token3', 'Snorlax', 'https://item.kakaocdn.net/do/9f6391218e3a68eb052a0e6bdd46e649ce9463e040a07a9462a54df43e1d73f1');

-- Daily 테이블에 더미 데이터 삽입 (오늘을 기준으로 앞뒤 3일)
INSERT INTO daily (date) VALUES
(CURRENT_DATE - INTERVAL 3 DAY),
(CURRENT_DATE - INTERVAL 2 DAY),
(CURRENT_DATE - INTERVAL 1 DAY),
(CURRENT_DATE),
(CURRENT_DATE + INTERVAL 1 DAY),
(CURRENT_DATE + INTERVAL 2 DAY),
(CURRENT_DATE + INTERVAL 3 DAY);



-- DailyQuestion 테이블에 더미 데이터 삽입
-- 여기서는 question_id가 이미 존재한다고 가정
INSERT INTO daily_question (question_id, daily_id) VALUES
(1, 1), (2, 1), (3, 1),
(4, 2), (5, 2), (6, 2),
(7, 3), (8, 3), (9, 3),
(10, 4), (11, 4), (12, 4),
(13, 5), (14, 5), (15, 5),
(16, 6), (17, 6), (18, 6),
(19, 7), (20, 7), (21, 7);


-- Answer 테이블에 더미 데이터 삽입
-- 여기서는 user_id, question_id, tag_id, daily_id가 이미 존재한다고 가정
INSERT INTO answer (user_id, question_id, tag_id, daily_id, content, file) VALUES 
(1, 1, 1, 1, '저는 프로젝트 관리 분야에서 5년 이상의 경력을 가지고 있으며, 여러 고프로파일 프로젝트를 성공적으로 이끌었습니다.', 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3'), 
(2, 2, 1, 1, '저의 가장 큰 강점은 새로운 상황에 빠르게 적응하고 문제에 대한 혁신적인 해결책을 찾는 능력입니다.', 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3'), 
(3, 3, 1, 1, '이전 직장에서 새로운 소프트웨어 시스템을 도입하여 효율성을 20% 향상시켰습니다.', 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3'), 
(1, 4, 1, 2, '저는 팀워크를 중시하며, 협력하여 목표를 달성하는 데 주력합니다.', 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3'), 
(2, 5, 1, 2, '문제 해결 능력이 뛰어나며, 어려운 상황에서도 침착하게 대처할 수 있습니다.', 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3'), 
(3, 6, 1, 2, '저는 항상 학습하는 자세를 유지하며, 새로운 기술을 빠르게 습득합니다.', 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3'), 
(1, 7, 1, 3, '저는 고객의 요구사항을 정확히 파악하고, 맞춤형 솔루션을 제공하는 데 능숙합니다.', 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3'), 
(2, 8, 1, 3, '효율적인 시간 관리 능력을 통해 다수의 프로젝트를 동시에 진행할 수 있습니다.', 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3'), 
(3, 9, 1, 3, '저는 지속적인 개선을 추구하며, 프로세스를 최적화하는 데 중점을 둡니다.', 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3'), 
(1, 10, 1, 4, '팀의 사기를 높이고, 동료들과의 원활한 소통을 중요하게 생각합니다.', 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3'), 
(2, 11, 1, 4, '저는 책임감이 강하며, 맡은 일을 끝까지 완수하는 성격입니다.', 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3'), 
(3, 12, 1, 4, '창의적인 아이디어를 제안하고, 실행에 옮기는 것을 즐깁니다.', 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3'), 
(1, 13, 1, 5, '저는 데이터 분석을 통해 인사이트를 도출하고, 전략적 결정을 내리는 데 도움을 줍니다.', 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3'), 
(2, 14, 1, 5, '끊임없이 변화하는 시장 환경에 맞춰 유연하게 대처할 수 있습니다.', 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3'), 
(3, 15, 1, 5, '저는 고객 만족을 최우선으로 생각하며, 높은 수준의 서비스를 제공하기 위해 노력합니다.', 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3'), 
(1, 16, 1, 6, '저는 복잡한 문제를 논리적으로 분석하고, 체계적으로 해결하는 능력을 갖추고 있습니다.', 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3'), 
(2, 17, 1, 6, '팀 내에서 리더십을 발휘하여, 구성원들이 최고의 성과를 낼 수 있도록 지원합니다.', 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3'), 
(3, 18, 1, 6, '저는 다양한 문화와 배경을 가진 사람들과 원활하게 협력할 수 있는 능력을 가지고 있습니다.', 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3'), 
(1, 19, 1, 7, '저는 새로운 도전을 즐기며, 항상 발전을 위해 노력합니다.', 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3'), 
(2, 20, 1, 7, '고객의 피드백을 적극적으로 반영하여, 서비스 품질을 지속적으로 개선합니다.', 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3'), 
(3, 21, 1, 7, '저는 팀워크를 중요하게 생각하며, 공동의 목표를 위해 협력합니다.', 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3');

