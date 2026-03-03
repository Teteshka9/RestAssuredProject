package dto;

import domain.AdvancedNote;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


public record RequestDTO(
        @NotBlank(message="title can not be empty")
        String title,

        String body,
        String createdAt,
        List<NoteTag> tags) {

        public RequestDTO(AdvancedNote data) {
        this(data.getTitle(), data.getTag(), data.getCreatedAt(),
                List.of(NoteTag.valueOf(data.getTag().toUpperCase()))); // Вызываем основной конструктор (this)
}
}
