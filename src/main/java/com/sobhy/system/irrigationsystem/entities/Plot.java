package com.sobhy.system.irrigationsystem.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "plots")
public class Plot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String plotName;

    @OneToMany(mappedBy = "plot", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TimeSlot> timeSlots;

    @CreationTimestamp
    @Column(name = "creation_time", updatable = false)
    private Timestamp createdTime;

    @UpdateTimestamp
    @Column(name = "last_updated_time", updatable = false)
    private Timestamp lastUpdatedTime;
}
