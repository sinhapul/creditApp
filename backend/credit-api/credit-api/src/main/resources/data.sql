-- src/main/resources/data.sql

-- Users
INSERT INTO user (id, name, phone_number, email) VALUES
  (1, 'Alice Johnson', '9999990001', 'alice.johnson@example.com'),
  (2, 'Bob Smith',     '9999990002', 'bob.smith@example.com');

-- Transactions
INSERT INTO transaction (
  id,
  user_id,
  description,
  amount,
  timestamp,
  category_label
) VALUES
  (1, 1, 'Paid ₹500 for groceries',        500.00,  '2025-07-01 10:00:00', 'Expense'),
  (2, 1, 'Monthly electricity bill',      1200.00, '2025-06-28 18:30:00', 'Expense'),
  (3, 1, 'Salary credited',              30000.00, '2025-06-30 09:00:00', 'Income'),
  (4, 2, 'Phone recharge ₹300',            300.00,  '2025-07-02 12:00:00', 'Expense'),
  (5, 2, 'Loan repayment installment',    1500.00, '2025-07-05 08:00:00', 'Repayment');

-- Loans
INSERT INTO loan (
  id,
  user_id,
  principal_amount,
  interest_rate,
  repayment_frequency,
  start_date,
  end_date,
  status
) VALUES
  (1, 1, 10000.00, 12.5, 'weekly', '2025-07-05 09:00:00', '2025-08-05 09:00:00', 'ACTIVE'),
  (2, 2,  5000.00, 15.0, 'daily',  '2025-07-10 10:30:00', '2025-07-25 10:30:00', 'PENDING');
