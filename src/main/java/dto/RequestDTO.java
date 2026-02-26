package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


public record RequestDTO(
        @NotBlank(message="title can not be empty")
        String title,

        String body,
        String createdAt,
        List<NoteTag> tags

) {
}
