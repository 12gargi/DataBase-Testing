delimiter //

create procedure get_order_by_cust(
   in cust_no int,
   out shipped int,
   out canceled int,
   out resolved int,
   out disputed int)
begin 
   -- shipped
   select count(*) into shipped from orders where customerNumber = cust_no and status = 'shipped';
   
   -- canceled
   select count(*) into canceled from orders where customerNumber = cust_no and status = 'canceled';
   
   -- resolved
   select count(*) into resolved from orders where customerNumber = cust_no and status = 'resolved';
   
   -- disputed
   select count(*) into disputed from orders where customerNumber = cust_no and status = 'disputed';
   
   end // 
   
   delimiter ;
   
   
call get_order_by_cust(141,@shipped,@cancelled,@resolved,@disputed);

select @shipped,@cancelled,@resolved,@disputed;
   
   
   
  