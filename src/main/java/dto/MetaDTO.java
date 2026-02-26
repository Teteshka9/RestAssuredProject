package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import domain.AdvancedNote;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MetaDTO(
    String id,
    UUID collectionId,
    Integer projectId,
    UUID appUserId,
    Integer createdBy,
    String createdAt,
    String updatedAt,
    String deletedAt,
    AdvancedNote data){}

