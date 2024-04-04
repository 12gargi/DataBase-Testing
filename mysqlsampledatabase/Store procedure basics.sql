delimiter //  /*as Stored procedure is block of code to make it look like block of code we use delimter*/

create procedure SelectAllcustomer()
Begin
    select * from customers;
End //

delimiter ;

call SelectAllcustomer();  # to invoke the store procedure