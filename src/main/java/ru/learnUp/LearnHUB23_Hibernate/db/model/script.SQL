CREATE TABLE post (
   id serial not null,
   title text not null,
   "text" text not null
);




alter table post add constraint post_pk PRIMARY KEY (id);

CREATE TABLE comment (
   id serial not null,
   "text" text not null,
   post_id int
);

alter table comment add constraint comment_pk PRIMARY KEY (id);
alter table comment add foreign key (post_id) references post(id);

insert into post (title, "text") values ('Hello', 'Hello world!');

insert into "comment" ("text", post_id) values ('Good content', 1);
insert into "comment" ("text", post_id) values ('Wow', 1);
insert into "comment" ("text", post_id) values ('Cool', 1);

--select * from post p join "comment" c on p.id = c.post_id
select * from "public".post p join "public"."comment" c on p.id = c.post_id