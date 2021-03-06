
package duantn.backend.dao;

import duantn.backend.model.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleReponsitory extends JpaRepository<Article, Integer> {
    // danh sách bài viết có trạng thái được duyệt
    Page<Article> findByDeletedFalse(Pageable pageable);
    List<Article> findByDeletedFalse();

    // tìm kiếm bài viết theo tiêu đề
    Page<Article> findByTitleLikeOrPhoneAndDeletedFalse(String title, String phone, Pageable pageable);
    List<Article> findByTitleLikeOrPhoneAndDeletedFalse(String title, String phone);

    // tìm kiếm theo id
    Article findByArticleIdAndDeletedFalse(Integer articleId);
    // tìm kiếm bài viết theo thời gian tăng dần
    Page<Article> findByDeletedFalseOrderByPostTimeAsc(Pageable pageable);
    List<Article> findByDeletedFalseOrderByPostTimeAsc();

    Page<Article> findByDeletedTrue(Pageable pageable);
    List<Article> findByDeletedTrue();

    /// tìm kiếm bài viết theo thời gian giảm dần
    Page<Article> findByDeletedFalseOrderByPostTimeDesc(Pageable pageable);

    List<Article> findByDeletedFalseOrderByPostTimeDesc();
}
