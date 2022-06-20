
CREATE TABLE public.employee
(
    employee_id          character varying(64)    NOT NULL,
    employee_name          character varying(64)    NOT NULL,
    employee_email          character varying(64)    NOT NULL,
    employee_password          character varying(64)    NOT NULL,
    date_joined       timestamp with time zone,
    CONSTRAINT employee_pk PRIMARY KEY (employee_id)

);



CREATE TABLE public.admin
(
    admin_id          character varying(64)    NOT NULL,
    admin_name        character varying(64)   NOT NULL,
    admin_username        character varying(64)   NOT NULL,
    admin_password        character varying(64)   NOT NULL,

    CONSTRAINT admin_pk PRIMARY KEY (admin_id)


);




