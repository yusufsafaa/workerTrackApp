# WorkerTrackApp
- ### This project is a fullstack web application developed using **Java Spring Boot** and **Angular CLI**. It implements **JWT-based authentication** and **role-based authorization** to ensure secure access to resources.

## Screenshots

<h3 align="center">LOGIN</h3>

![Login Sayfası](/images/login.png)
> The user login screen offers JWT-based authentication.

<br>

<h3 align="center">HOMEPAGE_ADMIN</h3>

![Login Sayfası](/images/anasayfa_admin.png)
> The main screen where, as an admin, we can view all employees as a table and perform all CRUD operations.

<br>

<h3 align="center">HOMEPAGE_USER</h3>

![Login Sayfası](/images/anasayfa_user.png)
> The main screen where, as a user, we can only view employees but cannot perform other CRUD operations.

<br>

<h3 align="center">ADD EMPLOYEE</h3>

![Login Sayfası](/images/calisan_ekle.png)
> Interface for adding a new employee (accessible only to users with the admin role).

<br>

<h3 align="center">EDIT EMPLOYEE</h3>

![Login Sayfası](/images/update_employee.png)
> Interface for updating an existing employee (accessible only to users with the admin role).

<br>

<h3 align="center">WORKLOGS PAGE_ADMIN</h3>

![Login Sayfası](/images/worklog_admin.png)
> The screen where we can view the worklog summary of all users for a specific month and year that we select.

<br>

<h3 align="center">LAST WORKLOGS DETAILS</h3>

![Login Sayfası](/images/son_yedi_gun.png)
> The screen where we can view the detailed worklogs of a selected user for the last 7 days and perform all CRUD operations as an ADMIN.

<br>

<h3 align="center">ADD WORKLOG</h3>

![Login Sayfası](/images/worklog_ekle.png)
> Interface for adding a new worklog for selected user. (accessible only to users with the admin role).

<br>

<h3 align="center">EDIT WORKLOG</h3>

![Login Sayfası](/images/worklog_duzenle.png)
> Interface for updating an existing worklog (accessible only to users with the admin role).

<br>

## Installation

### Backend Setup (Spring Boot)
1. Clone the repository:
    ```bash
    git clone https://github.com/yusufsafaa/workerTrackApp.git
    ```
2. Navigate to the project directory and install dependencies.
3. Configure `application.properties` with your database settings and any required environment variables.
4. Run the Spring Boot application:
    ```bash
    ./mvnw spring-boot:run
    ```

### Frontend Setup (Angular)
1. Navigate to the frontend directory:
    ```bash
    cd frontend
    ```
2. Install the dependencies:
    ```bash
    npm install
    ```
3. Run the Angular application:
    ```bash
    ng serve
    ```
4. Open `http://localhost:4200` in your browser to view the application.


## Built With
- **Java Spring Boot**: Backend framework for RESTful APIs.
- **Angular CLI**: Frontend framework for UI.
- **Spring Security**: For implementing authentication and authorization.
- **JWT**: JSON Web Token for secure authentication.
- **PostgreSQL**: Database options (modify according to preference in `application.properties`).

