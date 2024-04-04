use classicmodels;

drop table if exists WorkCenters;
drop table if exists WorkCenterStats;

create table WorkCenters(
    id INT auto_increment primary key,
    name varchar(100) not null,
    capacity int not null
    );
    
create table WorkCenterStats(
     totalCapacity int not null
     );