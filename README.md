# Etl-shifts
ETL job that fetches the data from the endpoint and persits do database.

- Shift management gradle app is getting data from REST endpoint api/v1/shifts using spring rest template via HTTP get method (Could be simpler, just calling getShifts() from service layer from shift app). After getting the date, we transform date into DTOs and then persist to DB (mySql) using spring data JPA.
This app runs by default on port 8080.

- Shift api gradle app is generating random data for every field. Simulating work of https://my.tanda.co/api/v2/documentation#shifts-shifts-get.
This app runs by default on port 8081.

- Note: from the response provided in pdf file, it can be concluded that all objects (except shift itself) are referencing to shift via shift_id.
Could be established relationships between ship and other table where shift_id could be foreing key to shift.
This is not implemented but can be done.
