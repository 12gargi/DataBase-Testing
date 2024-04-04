/*the store procedure should return number of days it would require to 
deliver a particular data, eg: for USA-> 2Days, for Canada->3Days ,for Othe-> 5days*/
delimiter // 

create procedure SetCustomerShipping(
    in pCustomerNumber int,
    out pShipping varchar(50)
    )
    
begin 
    declare customerCountry varchar(100);

select country into customerCountry from customers where customerNumber = pCustomerNumber;
    case customerCountry 
      when 'USA' then
        set pShipping = '2-day Shipping';
	  when 'canada' then 
        set pShipping = '3-day Shipping';
	  else
        set pShipping = '5-day shiping';
        
	end case;
end //

delimiter ;

call SetCustomerShipping(300,@shipping);
select @shipping;
