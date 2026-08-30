package com.springboot.restapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="books")
public class Book 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Title is required")
    private String title;

    @NotBlank(message="Author is required")
    private String author;

    @NotBlank(message="Category is required")
    private String category;

    @NotNull(message="Price is required")
    @Positive(message="Price must be greater than 0")
    private Double price;

    @NotNull(message="Select Availability")
    private Boolean available;

    private Boolean deleted=false;
}
