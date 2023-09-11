INSERT INTO "connectorDomain" ("module_id", "created_at", "name", "module_name", "type", "client_id")
VALUES
    ('orchestra', now(), 'Payroll SILAE', '1', 'INOUT', 1),
    ('orchestra', now(), 'Time E2Times', '2', 'IN', 1),
    ('orchestra', now(), 'BDES Editions Legislatives', '3', 'INOUT', 1),
    ('orchestra', now(), 'Communication Cornerstone', '4', 'OUT', 1);

-- Sample from screenshots from jira. First row is a previous version of the same flow as RELEASED that should be ignored in the retrieved data
INSERT INTO "flow" ("is_active", "flow_version", "created_at", "exe_status", "exe_status_date", "exe_type", "flow_id", "mapping_status", "name", "status", "type", "validated_at", "connector_id")
VALUES
    ('1', '1.0', '2022-08-29 21:00:14.449016+00', 'SUCCESS', '2022-08-30 21:00:14.449016+00', 'SCHEDULED', 'usr', 'CONFIRMED', 'User', 'RELEASE', 'OUT', '2022-08-29 22:00:14.449016+00', '1'),
    ('1', '1.1', now(), 'SUCCESS', now(), 'SCHEDULED', 'usr', 'CONFIRMED', 'User', 'RELEASE', 'OUT', now(), '1'),
    ('1', '1.0', now(), 'RUNNING', now(), 'REAL_TIME', 'contracts', 'CONFIRMED', 'Contracts', 'RELEASE', 'IN', now(), '1'),
    ('0', '1.0', now(), NULL, NULL, 'REAL_TIME', 'legal_entity', 'CONFIRMED', 'Legal Entity', 'RELEASE', 'IN', now(), '1'),
    ('0', '1.1', now(), NULL, NULL, NULL, 'legal_entity', 'TO_CONFIRM', 'Legal Entity', 'DRAFT', 'IN', NULL, '1');

INSERT INTO "schedule" (id, end_date, execution_time, frequency, is_maintenance, next_run, previous_run, select_day, start_date)
VALUES
    ('1', '2026-12-31 23:59:59.000000', '14:00:00', 'WEEKLY', 'false', '2022-09-12 16:11:08.000000', NULL, 'MONDAY', '2022-09-01 00:00:00.000000'),
    ('2', '2026-12-31 23:59:59.000000', '18:00:00', 'MONTHLY', 'false', '2022-09-12 16:11:08.000000', NULL, 'FRIDAY', '2022-09-01 00:00:00.000000'),
    ('3', '2026-12-31 23:59:59.000000', '09:30:00', 'DAILY', 'true', '2022-09-12 16:11:08.000000', NULL, '', '2022-09-01 00:00:00.000000');
