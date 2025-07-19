-- USER: Apollo
INSERT INTO users (username, phone_number, email)
VALUES ('Apollo', '3333333333', 'apollo@example.com');

-- LOAN for Apollo
INSERT INTO loans (user_id, principal_amount, interest_rate, repayment_frequency, start_date, end_date, status)
VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    300000.00, 8.5, 'WEEKLY', '2024-07-01 10:00:00', '2025-01-27 10:00:00', 'ACTIVE'
);

-- 30 WEEKLY TRANSACTIONS FOR APOLLO

-- Week 1
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2024-07-08 10:00:00', '2024-07-08 09:00:00', TRUE, 11000.00, 11000.00, 10500.00, 500.00, 0.00, 300000.00, 289500.00,
    'UPI', 'TXNAP01', 'INR', 'Bangalore', 'Week 1: On time', 'EMI'
);

-- Week 2
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2024-07-15 10:00:00', '2024-07-15 10:00:00', TRUE, 11000.00, 11000.00, 10520.00, 480.00, 0.00, 289500.00, 279000.00,
    'UPI', 'TXNAP02', 'INR', 'Bangalore', 'Week 2: On time', 'EMI'
);

-- Week 3
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2024-07-22 10:00:00', '2024-07-22 10:05:00', TRUE, 11000.00, 11000.00, 10540.00, 460.00, 0.00, 279000.00, 268460.00,
    'Card', 'TXNAP03', 'INR', 'Bangalore', 'Week 3: On time', 'EMI'
);

-- Week 4
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2024-07-29 10:00:00', '2024-07-29 09:30:00', TRUE, 11000.00, 11000.00, 10560.00, 440.00, 0.00, 268460.00, 257900.00,
    'NetBanking', 'TXNAP04', 'INR', 'Bangalore', 'Week 4: On time', 'EMI'
);

-- Week 5
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2024-08-05 10:00:00', '2024-08-05 10:00:00', TRUE, 11000.00, 11000.00, 10580.00, 420.00, 0.00, 257900.00, 247320.00,
    'UPI', 'TXNAP05', 'INR', 'Bangalore', 'Week 5: On time', 'EMI'
);

-- Week 6
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2024-08-12 10:00:00', '2024-08-12 10:10:00', TRUE, 11000.00, 11000.00, 10600.00, 400.00, 0.00, 247320.00, 236720.00,
    'Card', 'TXNAP06', 'INR', 'Bangalore', 'Week 6: On time', 'EMI'
);

-- Week 7
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2024-08-19 10:00:00', '2024-08-19 09:00:00', TRUE, 11000.00, 11000.00, 10620.00, 380.00, 0.00, 236720.00, 226100.00,
    'UPI', 'TXNAP07', 'INR', 'Bangalore', 'Week 7: On time', 'EMI'
);

-- Week 8
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2024-08-26 10:00:00', '2024-08-26 10:00:00', TRUE, 11000.00, 11000.00, 10640.00, 360.00, 0.00, 226100.00, 215460.00,
    'UPI', 'TXNAP08', 'INR', 'Bangalore', 'Week 8: On time', 'EMI'
);

-- Week 9
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2024-09-02 10:00:00', '2024-09-02 10:12:00', TRUE, 11000.00, 11000.00, 10660.00, 340.00, 0.00, 215460.00, 204800.00,
    'NetBanking', 'TXNAP09', 'INR', 'Bangalore', 'Week 9: On time', 'EMI'
);

-- Week 10
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2024-09-09 10:00:00', '2024-09-09 10:00:00', TRUE, 11000.00, 11000.00, 10680.00, 320.00, 0.00, 204800.00, 194120.00,
    'UPI', 'TXNAP10', 'INR', 'Bangalore', 'Week 10: On time', 'EMI'
);

-- Week 11
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2024-09-16 10:00:00', '2024-09-16 10:15:00', TRUE, 11000.00, 11000.00, 10700.00, 300.00, 0.00, 194120.00, 183420.00,
    'UPI', 'TXNAP11', 'INR', 'Bangalore', 'Week 11: On time', 'EMI'
);

-- Week 12
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2024-09-23 10:00:00', '2024-09-23 09:58:00', TRUE, 11000.00, 11000.00, 10720.00, 280.00, 0.00, 183420.00, 172700.00,
    'Card', 'TXNAP12', 'INR', 'Bangalore', 'Week 12: On time', 'EMI'
);

-- Week 13
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2024-09-30 10:00:00', '2024-09-30 10:00:00', TRUE, 11000.00, 11000.00, 10740.00, 260.00, 0.00, 172700.00, 161960.00,
    'UPI', 'TXNAP13', 'INR', 'Bangalore', 'Week 13: On time', 'EMI'
);

-- Week 14
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2024-10-07 10:00:00', '2024-10-07 10:00:00', TRUE, 11000.00, 11000.00, 10760.00, 240.00, 0.00, 161960.00, 151200.00,
    'UPI', 'TXNAP14', 'INR', 'Bangalore', 'Week 14: On time', 'EMI'
);

-- Week 15
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2024-10-14 10:00:00', '2024-10-14 09:55:00', TRUE, 11000.00, 11000.00, 10780.00, 220.00, 0.00, 151200.00, 140420.00,
    'NetBanking', 'TXNAP15', 'INR', 'Bangalore', 'Week 15: On time', 'EMI'
);

-- Week 16
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2024-10-21 10:00:00', '2024-10-21 10:00:00', TRUE, 11000.00, 11000.00, 10800.00, 200.00, 0.00, 140420.00, 129620.00,
    'UPI', 'TXNAP16', 'INR', 'Bangalore', 'Week 16: On time', 'EMI'
);

-- Week 17
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2024-10-28 10:00:00', '2024-10-28 10:10:00', TRUE, 11000.00, 11000.00, 10820.00, 180.00, 0.00, 129620.00, 118800.00,
    'Card', 'TXNAP17', 'INR', 'Bangalore', 'Week 17: On time', 'EMI'
);

-- Week 18
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2024-11-04 10:00:00', '2024-11-04 10:05:00', TRUE, 11000.00, 11000.00, 10840.00, 160.00, 0.00, 118800.00, 107960.00,
    'UPI', 'TXNAP18', 'INR', 'Bangalore', 'Week 18: On time', 'EMI'
);

-- Week 19
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2024-11-11 10:00:00', '2024-11-11 09:58:00', TRUE, 11000.00, 11000.00, 10860.00, 140.00, 0.00, 107960.00, 97100.00,
    'UPI', 'TXNAP19', 'INR', 'Bangalore', 'Week 19: On time', 'EMI'
);

-- Week 20
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2024-11-18 10:00:00', '2024-11-18 10:00:00', TRUE, 11000.00, 11000.00, 10880.00, 120.00, 0.00, 97100.00, 86220.00,
    'NetBanking', 'TXNAP20', 'INR', 'Bangalore', 'Week 20: On time', 'EMI'
);

-- Week 21 (late payment)
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2024-11-25 10:00:00', '2024-11-27 10:00:00', FALSE, 11000.00, 11200.00, 10900.00, 100.00, 200.00, 86220.00, 75320.00,
    'Card', 'TXNAP21', 'INR', 'Bangalore', 'Week 21: Late, with late fee', 'EMI'
);

-- Week 22
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2024-12-02 10:00:00', '2024-12-02 10:00:00', TRUE, 11000.00, 11000.00, 10920.00, 80.00, 0.00, 75320.00, 64400.00,
    'UPI', 'TXNAP22', 'INR', 'Bangalore', 'Week 22: On time', 'EMI'
);

-- Week 23
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2024-12-09 10:00:00', '2024-12-09 10:00:00', TRUE, 11000.00, 11000.00, 10940.00, 60.00, 0.00, 64400.00, 53460.00,
    'UPI', 'TXNAP23', 'INR', 'Bangalore', 'Week 23: On time', 'EMI'
);

-- Week 24
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2024-12-16 10:00:00', '2024-12-16 10:00:00', TRUE, 11000.00, 11000.00, 10960.00, 40.00, 0.00, 53460.00, 42500.00,
    'NetBanking', 'TXNAP24', 'INR', 'Bangalore', 'Week 24: On time', 'EMI'
);

-- Week 25 (late payment)
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2024-12-23 10:00:00', '2024-12-26 10:00:00', FALSE, 11000.00, 11250.00, 10980.00, 20.00, 250.00, 42500.00, 31520.00,
    'UPI', 'TXNAP25', 'INR', 'Bangalore', 'Week 25: Late, with late fee', 'EMI'
);

-- Week 26
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2024-12-30 10:00:00', '2024-12-30 10:00:00', TRUE, 11000.00, 11000.00, 11000.00, 0.00, 0.00, 31520.00, 20520.00,
    'UPI', 'TXNAP26', 'INR', 'Bangalore', 'Week 26: On time', 'EMI'
);

-- Week 27
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2025-01-06 10:00:00', '2025-01-06 10:00:00', TRUE, 11000.00, 11000.00, 11000.00, 0.00, 0.00, 20520.00, 9520.00,
    'NetBanking', 'TXNAP27', 'INR', 'Bangalore', 'Week 27: On time', 'EMI'
);

-- Week 28 (late payment)
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2025-01-13 10:00:00', '2025-01-17 10:00:00', FALSE, 11000.00, 11200.00, 10900.00, 100.00, 200.00, 9520.00, 0.00,
    'UPI', 'TXNAP28', 'INR', 'Bangalore', 'Week 28: Late, closes loan', 'EMI'
);

-- Week 29 (closure record)
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2025-01-20 10:00:00', '2025-01-20 10:00:00', TRUE, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00,
    'UPI', 'TXNAP29', 'INR', 'Bangalore', 'Week 29: No due, loan closed', 'EMI'
);

-- Week 30 (closure record)
INSERT INTO transactions (
    user_id, loan_id, due_date, payment_date, paid_on_time, scheduled_amount, amount_paid,
    principal_component, interest_component, late_fee, previous_balance, remaining_balance,
    payment_method, payment_reference, currency, location, notes, category_label
) VALUES (
    (SELECT id FROM users WHERE username = 'Apollo'),
    (SELECT l.id FROM loans l JOIN users u ON l.user_id = u.id WHERE u.username = 'Apollo'),
    '2025-01-27 10:00:00', '2025-01-27 10:00:00', TRUE, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00,
    'UPI', 'TXNAP30', 'INR', 'Bangalore', 'Week 30: Loan fully repaid', 'EMI'
);
