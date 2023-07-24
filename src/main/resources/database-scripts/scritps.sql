create table alerts
(
    id int4 not null primary key,
    message VARCHAR(100) not null,
    timestamp timestamptz not null default CURRENT_TIMESTAMP
);

create table plots
(
    id int4 not null primary key,
    name VARCHAR(100) not null,
    creation_time timestamptz not null default CURRENT_TIMESTAMP,
    lastUpdatedTime timestamptz not null default CURRENT_TIMESTAMP
);

create table time_slots
(
    id int4 not null primary key,
    startTime timestamptz not null,
    endTime timestamptz not null,
    plot_id int4 not null,
    FOREIGN KEY (plot_id) REFERENCES plots(id)
);

create table sensor_status
(
    id int4 not null primary key,
    irrigated boolean not null,
    timeslot_id int4 not null,

    FOREIGN KEY (timeslot_id) REFERENCES time_slots(id)
);