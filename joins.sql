1.Write a query to display all the bills with meter details. Display the records in ascending order based on payable amount.
SELECT *
FROM bill b
JOIN meter m ON b.meter_id = m.id
ORDER BY b.payable_amount ASC;
