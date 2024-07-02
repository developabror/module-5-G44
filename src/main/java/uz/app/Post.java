package uz.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor@NoArgsConstructor
public class Post {
    private String category;
    private String content;
    private Long id;
    private String image;
    private String publishedAt;
    private String slug;
    private String status;
    private String thumbnail;
    private String title;
    private String updatedAt;
    private String url;
    private Long userId;
}
