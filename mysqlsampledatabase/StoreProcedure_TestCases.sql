use CLASSICMODELS;

show procedure status where db = 'classicmodels';
-- OR
show procedure status where name ='SelectAllcustomer';

call SelectAllcustomer();

call SelectAllCustomerByCityAndPin('Singapore','079903');
select * from customers where city = 'Singapore' and postalCode='079903';




call get_order_by_cust(141,@shipped,@canceled,@resolved,@disputed);
SELECT @shipped,@cancelled,@resolved,@disputed;
select
(SELECT count(*) as 'shipped' FROM orders WHERE customerNumber = 141 AND status = 'Shipped') as Shipped,
(SELECT count(*) as 'canceled' FROM orders WHERE customerNumber = 141 AND status = 'Canceled') as Canceled,
(SELECT count(*) as 'resolved' FROM orders WHERE customerNumber = 141 AND status = 'Resolved') as Resolved,
(SELECT count(*) as 'disputed' FROM orders WHERE customerNumber = 141 AND status = 'Disputed') as Disputed


CALL SetCustomerShipping(112,@shipping);
SELECT @shipping AS ShippingTime;
CALL SetCustomerShipping(260,@shipping);
SELECT @shipping AS ShippingTime;
CALL SetCustomerShipping(353,@shipping);
SELECT @shipping AS ShippingTime;

SELECT country,
CASE
WHEN country='USA' THEN '2-day Shipping'
       WHEN country = 'Canada' THEN '3-day Shipping'
      ELSE '5-day Shipping'
END as ShippingTime
   FROM customers WHERE customerNumber =112;




