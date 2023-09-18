CREATE
DATABASE motorph;

CREATE TABLE Employee
(
    employeeNumber       INT PRIMARY KEY,
    lastName             VARCHAR(255),
    firstName            VARCHAR(255),
    birthday             DATE,
    address              VARCHAR(255),
    phoneNumber          VARCHAR(15),
    sssNumber            VARCHAR(20),
    philhealthNumber     VARCHAR(20),
    tinNumber            VARCHAR(20),
    pagIbigNumber        VARCHAR(20),
    status               VARCHAR(50),
    position             VARCHAR(100),
    immediateSupervisor  VARCHAR(255),
    basicSalary          DECIMAL(10, 2),
    riceSubsidy          DECIMAL(10, 2),
    phoneAllowance       DECIMAL(10, 2),
    clothingAllowance    DECIMAL(10, 2),
    grossSemiMonthlyRate DECIMAL(10, 2),
    hourlyRate           DECIMAL(10, 2)
);

-- Start employee number to 10_001
ALTER TABLE Employee AUTO_INCREMENT = 10001;

-- Sample

CREATE TABLE Attendance
(
    id             INT AUTO_INCREMENT PRIMARY KEY,
    employeeNumber INT,
    lastName       VARCHAR(255),
    firstName      VARCHAR(255),
    date           DATE,
    timeIn         TIME,
    timeOut        TIME
);

