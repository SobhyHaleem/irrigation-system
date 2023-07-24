package com.sobhy.system.irrigationsystem.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "time_slots")
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "startTime")
    private Timestamp startTime;

    @Column(name = "endTime")
    private Timestamp endTime;

    @ManyToOne
    @JoinColumn(name = "plot_id")
    private Plot plot;

    @OneToOne(mappedBy = "timeSlot", cascade = CascadeType.ALL)
    private SensorStatus sensorStatus;
}
