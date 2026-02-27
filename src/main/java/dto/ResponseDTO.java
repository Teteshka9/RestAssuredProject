package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import domain.AdvancedNote;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResponseDTO(
        String id,
        @JsonProperty("project_id") int projectId,
        AdvancedNote data) {}
