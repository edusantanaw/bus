package com.edusantanaw.bus.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "place")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String slug;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String state;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;
    @Column(nullable = false)
    @LastModifiedDate
    private Date updatedAt;
}
