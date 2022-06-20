flyway migrate  -url="jdbc:postgresql://localhost:5432/EmployeeManagement" -user="postgres" -password="password" -locations="filesystem:/Users/atlantis/Documents/Encentral/shared/user-management-base/entities/src/main/resources/db/migration/default/,filesystem:./"



ocker run --name some-postgres -e POSTGRES_PASSWORD=password  -e POSTGRES_USER=postgres -d -e POSTGRES_DB=EmployeeManagement -p5432:5432 postgres:11