Use Blog;

insert into user(
id, name, username, password, email, enabled)
values
(1, "Steward", "admin", "password", "sst@blog.com", true),
(2, "Kahn", "user", "password", "kh@gmail.com",  true);


insert into role(id, role)
    values(1,"ROLE_ADMIN"), 
    (2,"ROLE_USER");
    
insert into user_role(user_id, role_id)
    values(1,1),(1,2),(2,2);