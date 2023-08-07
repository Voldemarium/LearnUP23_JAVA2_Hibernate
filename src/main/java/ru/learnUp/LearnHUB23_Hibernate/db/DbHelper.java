package ru.learnUp.LearnHUB23_Hibernate.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.learnUp.LearnHUB23_Hibernate.db.model.Post;

import java.util.List;

public class DbHelper {

    private final SessionFactory sessionFactory;

    public DbHelper() {
        Configuration configuration = new Configuration()
                .configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    public void createDDL(String queryDDL) {
//        try здесь используется автоматич закрытия сессии (AutoClosable)
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createNativeQuery(queryDDL).executeUpdate();
            transaction.commit();
        }
    }

    //    Получение списка всех постов
    public List<Post> getPosts() {
        Session session = sessionFactory.openSession();
        List<Post> posts = session.createQuery("from Post", Post.class).list();
        session.close();
        return posts;
    }

    //Создание Post
    public void savePost(Post post) {
//        try здесь используется автоматич закрытия сессии (AutoClosable)
        Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(post);
            transaction.commit();
            session.close();
    }


    public Post getPostById(Long id) {

        return null;
    }

    // Удаление Post
    public boolean deletePost(Post post) {
//        try здесь используется автоматич закрытия сессии (AutoClosable)
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
//            Post post1 = session.find(Post.class, post.getId());
            session.remove(session.find(Post.class, post.getId()));
            transaction.commit();
            return true;
        }
    }


}
