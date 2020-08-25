package com.markqt.mongo.model;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class BaseEntity {

	@Id
	private ObjectId id;
	@CreatedDate
	private LocalDateTime createdAt;

}