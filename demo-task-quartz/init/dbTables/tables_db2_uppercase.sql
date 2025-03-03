create table QRTZ_JOB_DETAILS (
                                sched_name varchar(120) not null,
                                job_name varchar(80) not null,
                                job_group varchar(80) not null,
                                description varchar(120) null,
                                job_class_name varchar(128) not null,
                                is_durable varchar(1) not null,
                                is_nonconcurrent varchar(1) not null,
                                is_update_data varchar(1) not null,
                                requests_recovery varchar(1) not null,
                                job_data blob(2000),
                                primary key (sched_name,job_name,job_group)
)

create table QRTZ_TRIGGERS(
                            sched_name varchar(120) not null,
                            trigger_name varchar(80) not null,
                            trigger_group varchar(80) not null,
                            job_name varchar(80) not null,
                            job_group varchar(80) not null,
                            description varchar(120) null,
                            next_fire_time bigint,
                            prev_fire_time bigint,
                            priority integer,
                            trigger_state varchar(16) not null,
                            trigger_type varchar(8) not null,
                            start_time bigint not null,
                            end_time bigint,
                            calendar_name varchar(80),
                            misfire_instr smallint,
                            job_data blob(2000),
                            primary key (sched_name,trigger_name,trigger_group),
                            foreign key (sched_name,job_name,job_group) references QRTZ_JOB_DETAILS(sched_name,job_name,job_group)
)

create table QRTZ_SIMPLE_TRIGGERS(
                                   sched_name varchar(120) not null,
                                   trigger_name varchar(80) not null,
                                   trigger_group varchar(80) not null,
                                   repeat_count bigint not null,
                                   repeat_interval bigint not null,
                                   times_triggered bigint not null,
                                   primary key (sched_name,trigger_name,trigger_group),
                                   foreign key (sched_name,trigger_name,trigger_group) references QRTZ_TRIGGERS(sched_name,trigger_name,trigger_group)
)

create table QRTZ_CRON_TRIGGERS(
                                 sched_name varchar(120) not null,
                                 trigger_name varchar(80) not null,
                                 trigger_group varchar(80) not null,
                                 cron_expression varchar(120) not null,
                                 time_zone_id varchar(80),
                                 primary key (sched_name,trigger_name,trigger_group),
                                 foreign key (sched_name,trigger_name,trigger_group) references QRTZ_TRIGGERS(sched_name,trigger_name,trigger_group)
)

CREATE TABLE QRTZ_SIMPROP_TRIGGERS
(
  sched_name varchar(120) not null,
  TRIGGER_NAME VARCHAR(200) NOT NULL,
  TRIGGER_GROUP VARCHAR(200) NOT NULL,
  STR_PROP_1 VARCHAR(512) NULL,
  STR_PROP_2 VARCHAR(512) NULL,
  STR_PROP_3 VARCHAR(512) NULL,
  INT_PROP_1 INT NULL,
  INT_PROP_2 INT NULL,
  LONG_PROP_1 BIGINT NULL,
  LONG_PROP_2 BIGINT NULL,
  DEC_PROP_1 NUMERIC(13,4) NULL,
  DEC_PROP_2 NUMERIC(13,4) NULL,
  BOOL_PROP_1 VARCHAR(1) NULL,
  BOOL_PROP_2 VARCHAR(1) NULL,
  PRIMARY KEY (sched_name,TRIGGER_NAME,TRIGGER_GROUP),
  FOREIGN KEY (sched_name,TRIGGER_NAME,TRIGGER_GROUP)
    REFERENCES QRTZ_TRIGGERS(sched_name,TRIGGER_NAME,TRIGGER_GROUP)
)

create table QRTZ_BLOB_TRIGGERS(
                                 sched_name varchar(120) not null,
                                 trigger_name varchar(80) not null,
                                 trigger_group varchar(80) not null,
                                 blob_data blob(2000) null,
                                 primary key (sched_name,trigger_name,trigger_group),
                                 foreign key (sched_name,trigger_name,trigger_group) references QRTZ_TRIGGERS(sched_name,trigger_name,trigger_group)
)

create table QRTZ_CALENDARS(
                             sched_name varchar(120) not null,
                             calendar_name varchar(80) not null,
                             calendar blob(2000) not null,
                             primary key (sched_name,calendar_name)
)

create table QRTZ_FIRED_TRIGGERS(
                                  sched_name varchar(120) not null,
                                  entry_id varchar(95) not null,
                                  trigger_name varchar(80) not null,
                                  trigger_group varchar(80) not null,
                                  instance_name varchar(80) not null,
                                  fired_time bigint not null,
                                  sched_time bigint not null,
                                  priority integer not null,
                                  state varchar(16) not null,
                                  job_name varchar(80) null,
                                  job_group varchar(80) null,
                                  is_nonconcurrent varchar(1) null,
                                  requests_recovery varchar(1) null,
                                  primary key (sched_name,entry_id)
);


create table QRTZ_PAUSED_TRIGGER_GRPS(
                                       sched_name varchar(120) not null,
                                       trigger_group  varchar(80) not null,
                                       primary key (sched_name,trigger_group)
);

create table QRTZ_SCHEDULER_STATE (
                                    sched_name varchar(120) not null,
                                    instance_name varchar(80) not null,
                                    last_checkin_time bigint not null,
                                    checkin_interval bigint not null,
                                    primary key (sched_name,instance_name)
);

create table QRTZ_LOCKS
(
  sched_name varchar(120) not null,
  lock_name  varchar(40) not null,
  primary key (sched_name,lock_name)
);
