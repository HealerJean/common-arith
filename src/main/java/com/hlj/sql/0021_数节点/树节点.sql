# 1、题目
# 给定一个表 tree，id 是树节点的编号， p_id 是它父节点的 id 。
#
# +----+------+
# | id | p_id |
# +----+------+
# | 1  | null |
# | 2  | 1    |
# | 3  | 1    |
# | 4  | 2    |
# | 5  | 2    |
# +----+------+
# 树中每个节点属于以下三种类型之一：
#
# 叶子：如果这个节点没有任何孩子节点。
# 根：如果这个节点是整棵树的根，即没有父节点。
# 内部节点：如果这个节点既不是叶子节点也不是根节点。
#  
#
# 写一个查询语句，输出所有节点的编号和节点的类型，并将结果按照节点编号排序。上面样例的结果为：
#
#  
#
# +----+------+
# | id | Type |
# +----+------+
# | 1  | Root |
# | 2  | Inner|
# | 3  | Leaf |
# | 4  | Leaf |
# | 5  | Leaf |
# +----+------+
#  
#
# 解释
#
# 节点 '1' 是根节点，因为它的父节点是 NULL ，同时它有孩子节点 '2' 和 '3' 。
# 节点 '2' 是内部节点，因为它有父节点 '1' ，也有孩子节点 '4' 和 '5' 。
# 节点 '3', '4' 和 '5' 都是叶子节点，因为它们都有父节点同时没有孩子节点。


# 2、数据准备
drop table if exists tree;
create table tree(
    id int,
    p_id int
);
INSERT INTO tree (id, p_id) VALUES (5, 2);
INSERT INTO tree (id, p_id) VALUES (4, 2);
INSERT INTO tree (id, p_id) VALUES (3, 1);
INSERT INTO tree (id, p_id) VALUES (2, 1);
INSERT INTO tree (id, p_id) VALUES (1, null);
select * from tree;


# 3、答案
select t.id,
       case
           when t.p_id is null  then 'Root'
           when t.id not in (select t2.p_id from tree t2 where  t2.p_id is not null ) then 'Leaf'
           else 'Inner' end as Type
from tree t order by t.id;

