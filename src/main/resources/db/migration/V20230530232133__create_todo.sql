create table Todo(
    `id` bigint not null AUTO_INCREMENT comment 'id',
    `title` varchar(50) not null comment 'todo名',
    `status` int(2) not null comment 'todoステータス',
    `deadline` datetime comment '期限日時',
    `created_at` datetime comment '作成日時',
    `updated_at` datetime comment '更新日時',
    primary key (id)
)
comment = "todo"
/*! engine=InnoDb */;;