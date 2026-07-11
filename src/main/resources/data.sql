-- ===== 1. DEPARTMENTS (부서) =====
INSERT INTO departments (department_name, budget_limit)
VALUES ('개발팀', 50000000);
INSERT INTO departments (department_name, budget_limit)
VALUES ('마케팅팀', 30000000);
INSERt INTO departments (department_name, budget_limit)
VALUES ('재무팀', 20000000);

-- ===== 2. USERS (임직원) =====
INSERT INTO users (department_id, name, employee_number, title, role, email, password)
VALUES (1, '김철수', 'EMP001', '사원', 'EMPLOYEE', 'chulsoo@company.com', '1234');
INSERT INTO users (department_id, name, employee_number, title, role, email, password)
VALUES (2, '이영희', 'EMP002', '부장', 'MANAGER', 'younghee@company.com', '1234');
INSERT INTO users (department_id, name, employee_number, title, role, email, password)
VALUES (3, '박재부', 'EMP003', '과장', 'FINANCE', 'jaemu@company.com', '1234');

-- ===== 3. BUDGET REQUESTS (예산신청서) =====
INSERT INTO budget_requests (user_id, budget_amount, comment, title, status)
VALUES (1, 5000000, '개발 장비 구매 필요', '노트북 구매 요청', 'PENDING');
INSERT INTO budget_requests (user_id, budget_amount, comment, title, status)
VALUES (1, 10000000, '외부 교육 참여', '개발자 컨퍼런스 참가비', 'APPROVED');
INSERT INTO budget_requests (user_id, budget_amount, comment, title, status)
VALUES (2, 3000000, '팀 회식 및 워크샵', '팀 빌딩 행사 비용', 'REJECTED');

-- ===== 4. APPROVALS (결재) =====
INSERT INTO approvals (budget_request_id, user_id, approval_status, approval_step, comment)
VALUES (2, 2, 'APPROVED', '1차결재', '적절한 교육 비용으로 승인합니다');
INSERT INTO approvals (budget_request_id, user_id, approval_status, approval_step, comment)
VALUES (2, 3, 'APPROVED', '2차결재', '예산 범위 내 승인합니다');
INSERT INTO approvals (budget_request_id, user_id, approval_status, approval_step, comment)
VALUES (3, 2, 'REJECTED', '1차결재', '예산 초과로 반려합니다');

-- ===== 5. NOTIFICATIONS (알림) =====
INSERT INTO notifications (user_id, budget_request_id, message, is_read)
VALUES (1, 2, '예산 신청이 승인되었습니다', FALSE);
INSERT INTO notifications (user_id, budget_request_id, message, is_read)
VALUES (1, 3, '예산 신청이 반려되었습니다', FALSE);
INSERT INTO notifications (user_id, budget_request_id, message, is_read)
VALUES (2, 3, '결재 요청이 도착했습니다', TRUE);