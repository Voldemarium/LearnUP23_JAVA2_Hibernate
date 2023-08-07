package ru.learnUp.LearnHUB23_Hibernate;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.learnUp.LearnHUB23_Hibernate.db.DbHelper;
import ru.learnUp.LearnHUB23_Hibernate.db.model.Comment;
import ru.learnUp.LearnHUB23_Hibernate.db.model.Post;
import ru.learnUp.LearnHUB23_Hibernate.db.model.PostBuilder;

import java.util.List;

@Slf4j
public class Main {


	public static void main(String[] args) {
		DbHelper helper = new DbHelper();
//        helper.createDDL("alter table post add constraint post_pk PRIMARY KEY (id)");
//        helper.createDDL("alter table comment add constraint comment_pk PRIMARY KEY (id)");
//        helper.createDDL("alter table comment add foreign key (post_id) references post(id)");
//        helper.createDDL("drop table comment");
//        helper.createDDL("drop table post");

		List<Post> posts = helper.getPosts();
//		log.debug("posts: ", posts); //формат Post не подходит для Slf4j
		System.out.println(posts);


//		Post post = new PostBuilder()
//				.withTitle("Good")
//				.withText("Good")
//				.build();
//
//		post.setComments(List.of(
//				new Comment("Wow1", post),
//				new Comment("Wow2", post),
//				new Comment("Wow3", post)));
//
//		helper.savePost(post);
//		List<Post> allPosts = helper.getPosts();
//		System.out.println(allPosts);

	}

}
