# 1、题目 超过经理收入的员工
# Employee 表包含所有员工，他们的经理也属于员工。每个员工都有一个 Id，此外还有一列对应员工的经理的 Id。
#
# +----+-------+--------+-----------+
# | Id | Name  | Salary | ManagerId |
# +----+-------+--------+-----------+
# | 1  | Joe   | 70000  | 3         |
# | 2  | Henry | 80000  | 4         |
# | 3  | Sam   | 60000  | NULL      |
# | 4  | Max   | 90000  | NULL      |
# +----+-------+--------+-----------+
# 给定 Employee 表，编写一个 SQL 查询，该查询可以获取收入超过他们经理的员工的姓名。在上面的表格中，Joe 是唯一一个收入超过他的经理的员工。
#
# +----------+
# | Employee |
# +----------+
# | Joe      |
# +----------

# 2、数据准备
drop table if exists Employee;
create table Employee
(

    Id        int(11),
    Name      varchar(20),
    Salary    decimal(16, 2),
    ManagerId int(11)
)

# 3、答案
select e.Name as Employee
from Employee e  join Employee m on e.ManagerId = m.Id
where e.Salary > m.Salary;

