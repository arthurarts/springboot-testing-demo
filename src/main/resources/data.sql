-- CREATE TABLE CAMPAIGN_REGISTRATION (
--     id INT NOT NULL,
--     firstname VARCHAR(255),
--     lastname VARCHAR(255),
--     iban VARCHAR(255),
--     email VARCHAR(255),
--     campaignid INT NOT NULL
-- );

-- ALTER TABLE PUBLIC.CAMPAIGN_REGISTRATION ADD CAMPAIGNID INT NOT NULL;

-- ALTER TABLE CAMPAIGN_REGISTRATION
--     ADD FOREIGN KEY (campaignid)
--     REFERENCES campaign(id) ;


-- 3 +/- SELECT COUNT(*) FROM PUBLIC.CAMPAIGN;
INSERT INTO PUBLIC.CAMPAIGN(ID, NAME, CODE, START_DATE, END_DATE) VALUES
(1, 'Cick and Win', 'CAW', DATE '2017-09-30', DATE '2017-10-31'),
(2, 'Save and get Cashback', 'SAGCB', DATE '2017-09-30', DATE '2017-10-14'),
(3, 'Download and Win', 'DAW', DATE '2017-10-31', DATE '2017-12-01');

-- 1 +/- SELECT COUNT(*) FROM PUBLIC.CAMPAIGN_REGISTRATION;
-- INSERT INTO PUBLIC.CAMPAIGN_REGISTRATION(ID, CAMPAIGN_ID, EMAIL, FIRST_NAME, IBAN, LAST_NAME) VALUES
-- (1, 1, 'master.yoda@mdagobah.org', 'Master', 'NL90ING0000000555', 'Yoda');