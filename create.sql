
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
