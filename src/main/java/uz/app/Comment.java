
package uz.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor@NoArgsConstructor@Data
public class Comment {
    private String comment;
    private Long id;
    private Long postId;
    private Long userId;
}
