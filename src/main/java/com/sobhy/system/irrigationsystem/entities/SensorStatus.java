package com.sobhy.system.irrigationsystem.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "sensor_status")
public class SensorStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "irrigated")
    private boolean irrigated;

    @OneToOne
    @JoinColumn(name = "timeslot_id")
    private TimeSlot timeSlot;
}
