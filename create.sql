
    create table tb_customer (
        age integer not null,
        location varchar(2) not null,
        value_vehicle float(53),
        id bigserial not null,
        cpf varchar(14) not null unique,
        name varchar(200) not null,
        primary key (id)
    );

    create table tb_customer_insurance (
        id_customer bigint not null,
        id_insurance bigint not null
    );

    create table tb_insurance (
        cost integer not null,
        id bigserial not null,
        type varchar(10) not null,
        primary key (id)
    );

    alter table if exists tb_customer_insurance 
       add constraint FKcthjqs85l31evgmhd5tmwi123 
       foreign key (id_customer) 
       references tb_customer;

    alter table if exists tb_customer_insurance 
       add constraint FKf1xwbk7v5hvp3wve9vu6gfvq9 
       foreign key (id_insurance) 
       references tb_insurance;

    create table tb_customer (
        age integer not null,
        location varchar(2) not null,
        value_vehicle float(53),
        id bigserial not null,
        cpf varchar(14) not null unique,
        name varchar(200) not null,
        primary key (id)
    );

    create table tb_customer_insurance (
        id_customer bigint not null,
        id_insurance bigint not null
    );

    create table tb_insurance (
        cost integer not null,
        id bigserial not null,
        type varchar(10) not null,
        primary key (id)
    );

    create table tb_permission (
        id bigserial not null,
        description varchar(255),
        primary key (id)
    );

    create table tb_user_permission (
        id_permission bigint not null,
        id_user bigint not null
    );

    create table tb_users (
        account_non_expired boolean,
        account_non_locked boolean,
        credentials_non_expired boolean,
        enabled boolean,
        id bigserial not null,
        full_name varchar(255),
        password varchar(255),
        user_name varchar(255) unique,
        primary key (id)
    );

    alter table if exists tb_customer_insurance 
       add constraint FKcthjqs85l31evgmhd5tmwi123 
       foreign key (id_customer) 
       references tb_customer;

    alter table if exists tb_customer_insurance 
       add constraint FKf1xwbk7v5hvp3wve9vu6gfvq9 
       foreign key (id_insurance) 
       references tb_insurance;

    alter table if exists tb_user_permission 
       add constraint FKqsxlawmvr4dhvmhyhjmjjj3rt 
       foreign key (id_permission) 
       references tb_permission;

    alter table if exists tb_user_permission 
       add constraint FK1mmslma3r8q9981hfnpde2whl 
       foreign key (id_user) 
       references tb_users;

    create table tb_customer (
        age integer not null,
        location varchar(2) not null,
        value_vehicle float(53),
        id bigserial not null,
        cpf varchar(14) not null unique,
        name varchar(200) not null,
        primary key (id)
    );

    create table tb_customer_insurance (
        id_customer bigint not null,
        id_insurance bigint not null
    );

    create table tb_insurance (
        cost integer not null,
        id bigserial not null,
        type varchar(10) not null,
        primary key (id)
    );

    create table tb_permission (
        id bigserial not null,
        description varchar(255),
        primary key (id)
    );

    create table tb_user_permission (
        id_permission bigint not null,
        id_user bigint not null
    );

    create table tb_users (
        account_non_expired boolean,
        account_non_locked boolean,
        credentials_non_expired boolean,
        enabled boolean,
        id bigserial not null,
        full_name varchar(255),
        password varchar(255),
        user_name varchar(255) unique,
        primary key (id)
    );

    alter table if exists tb_customer_insurance 
       add constraint FKcthjqs85l31evgmhd5tmwi123 
       foreign key (id_customer) 
       references tb_customer;

    alter table if exists tb_customer_insurance 
       add constraint FKf1xwbk7v5hvp3wve9vu6gfvq9 
       foreign key (id_insurance) 
       references tb_insurance;

    alter table if exists tb_user_permission 
       add constraint FKqsxlawmvr4dhvmhyhjmjjj3rt 
       foreign key (id_permission) 
       references tb_permission;

    alter table if exists tb_user_permission 
       add constraint FK1mmslma3r8q9981hfnpde2whl 
       foreign key (id_user) 
       references tb_users;

    create table tb_customer (
        age integer not null,
        location varchar(2) not null,
        value_vehicle float(53),
        id bigserial not null,
        cpf varchar(14) not null unique,
        name varchar(200) not null,
        primary key (id)
    );

    create table tb_customer_insurance (
        id_customer bigint not null,
        id_insurance bigint not null
    );

    create table tb_insurance (
        cost integer not null,
        id bigserial not null,
        type varchar(10) not null,
        primary key (id)
    );

    create table tb_permission (
        id bigserial not null,
        description varchar(255),
        primary key (id)
    );

    create table tb_user_permission (
        id_permission bigint not null,
        id_user bigint not null
    );

    create table tb_users (
        account_non_expired boolean,
        account_non_locked boolean,
        credentials_non_expired boolean,
        enabled boolean,
        id bigserial not null,
        full_name varchar(255),
        password varchar(255),
        user_name varchar(255) unique,
        primary key (id)
    );

    alter table if exists tb_customer_insurance 
       add constraint FKcthjqs85l31evgmhd5tmwi123 
       foreign key (id_customer) 
       references tb_customer;

    alter table if exists tb_customer_insurance 
       add constraint FKf1xwbk7v5hvp3wve9vu6gfvq9 
       foreign key (id_insurance) 
       references tb_insurance;

    alter table if exists tb_user_permission 
       add constraint FKqsxlawmvr4dhvmhyhjmjjj3rt 
       foreign key (id_permission) 
       references tb_permission;

    alter table if exists tb_user_permission 
       add constraint FK1mmslma3r8q9981hfnpde2whl 
       foreign key (id_user) 
       references tb_users;

    create table tb_customer (
        age integer not null,
        location varchar(2) not null,
        value_vehicle float(53),
        id bigserial not null,
        cpf varchar(14) not null unique,
        name varchar(200) not null,
        primary key (id)
    );

    create table tb_customer_insurance (
        id_customer bigint not null,
        id_insurance bigint not null
    );

    create table tb_insurance (
        cost integer not null,
        id bigserial not null,
        type varchar(10) not null,
        primary key (id)
    );

    create table tb_permission (
        id bigserial not null,
        description varchar(255),
        primary key (id)
    );

    create table tb_user_permission (
        id_permission bigint not null,
        id_user bigint not null
    );

    create table tb_users (
        account_non_expired boolean,
        account_non_locked boolean,
        credentials_non_expired boolean,
        enabled boolean,
        id bigserial not null,
        full_name varchar(255),
        password varchar(255),
        user_name varchar(255) unique,
        primary key (id)
    );

    alter table if exists tb_customer_insurance 
       add constraint FKcthjqs85l31evgmhd5tmwi123 
       foreign key (id_customer) 
       references tb_customer;

    alter table if exists tb_customer_insurance 
       add constraint FKf1xwbk7v5hvp3wve9vu6gfvq9 
       foreign key (id_insurance) 
       references tb_insurance;

    alter table if exists tb_user_permission 
       add constraint FKqsxlawmvr4dhvmhyhjmjjj3rt 
       foreign key (id_permission) 
       references tb_permission;

    alter table if exists tb_user_permission 
       add constraint FK1mmslma3r8q9981hfnpde2whl 
       foreign key (id_user) 
       references tb_users;

    create table tb_customer (
        age integer not null,
        location varchar(2) not null,
        value_vehicle float(53),
        id bigserial not null,
        cpf varchar(14) not null unique,
        name varchar(200) not null,
        primary key (id)
    );

    create table tb_customer_insurance (
        id_customer bigint not null,
        id_insurance bigint not null
    );

    create table tb_insurance (
        cost integer not null,
        id bigserial not null,
        type varchar(10) not null,
        primary key (id)
    );

    create table tb_permission (
        id bigserial not null,
        description varchar(255),
        primary key (id)
    );

    create table tb_user_permission (
        id_permission bigint not null,
        id_user bigint not null
    );

    create table tb_users (
        account_non_expired boolean,
        account_non_locked boolean,
        credentials_non_expired boolean,
        enabled boolean,
        id bigserial not null,
        full_name varchar(255),
        password varchar(255),
        user_name varchar(255) unique,
        primary key (id)
    );

    alter table if exists tb_customer_insurance 
       add constraint FKcthjqs85l31evgmhd5tmwi123 
       foreign key (id_customer) 
       references tb_customer;

    alter table if exists tb_customer_insurance 
       add constraint FKf1xwbk7v5hvp3wve9vu6gfvq9 
       foreign key (id_insurance) 
       references tb_insurance;

    alter table if exists tb_user_permission 
       add constraint FKqsxlawmvr4dhvmhyhjmjjj3rt 
       foreign key (id_permission) 
       references tb_permission;

    alter table if exists tb_user_permission 
       add constraint FK1mmslma3r8q9981hfnpde2whl 
       foreign key (id_user) 
       references tb_users;

    create table tb_customer (
        age integer not null,
        location varchar(2) not null,
        value_vehicle float(53),
        id bigserial not null,
        cpf varchar(14) not null unique,
        name varchar(200) not null,
        primary key (id)
    );

    create table tb_customer_insurance (
        id_customer bigint not null,
        id_insurance bigint not null
    );

    create table tb_insurance (
        cost integer not null,
        id bigserial not null,
        type varchar(10) not null,
        primary key (id)
    );

    create table tb_permission (
        id bigserial not null,
        description varchar(255),
        primary key (id)
    );

    create table tb_user_permission (
        id_permission bigint not null,
        id_user bigint not null
    );

    create table tb_users (
        account_non_expired boolean,
        account_non_locked boolean,
        credentials_non_expired boolean,
        enabled boolean,
        id bigserial not null,
        full_name varchar(255),
        password varchar(255),
        user_name varchar(255) unique,
        primary key (id)
    );

    alter table if exists tb_customer_insurance 
       add constraint FKcthjqs85l31evgmhd5tmwi123 
       foreign key (id_customer) 
       references tb_customer;

    alter table if exists tb_customer_insurance 
       add constraint FKf1xwbk7v5hvp3wve9vu6gfvq9 
       foreign key (id_insurance) 
       references tb_insurance;

    alter table if exists tb_user_permission 
       add constraint FKqsxlawmvr4dhvmhyhjmjjj3rt 
       foreign key (id_permission) 
       references tb_permission;

    alter table if exists tb_user_permission 
       add constraint FK1mmslma3r8q9981hfnpde2whl 
       foreign key (id_user) 
       references tb_users;
