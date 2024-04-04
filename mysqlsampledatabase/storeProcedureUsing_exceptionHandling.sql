CREATE TABLE supplierProducts (
    supplierID int,
    productId int
);
 
delimiter //
create procedure InsertSupplierProduct(in inSupplierId int , in inProductId int)
begin
    -- exit if the duplicate key occurs
    declare exit handler for 1062 select 'Duplicate keys error encountered' Message;
    declare exit handler for sqlexception select 'SQLException entered' Message;
    declare exit handler for sqlstate '23000' select 'SQLSTATE 23000' ErrorCode;
    
    -- insert a new row into the SupplierProducts
    insert into supplierproducts(supplierId,productId) values(inSupplierId,inProductId);
    
    -- return the products supplied by the supplier id
	select count(*) from supplierproducts where supplierId = inSupplierId;
    
    end //
    
    delimiter ;
    
    call InsertSupplierProduct(1,1);
    call InsertSupplierProduct(1,2);
    call InsertSupplierProduct(1,3);
    
    call InsertSupplierProduct(1,3);
