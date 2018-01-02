package io.egen.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Tires {
    @Id
    private String id;
    private float frontLeft;
    private float frontRight;
    private float rearLeft;
    private float rearRight;
    public Tires(){
        this.id = UUID.randomUUID()
                .toString();
    }

    public float getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(float frontLeft) {
        this.frontLeft = frontLeft;
    }

    public float getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(float frontRight) {
        this.frontRight = frontRight;
    }

    public float getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(float rearLeft) {
        this.rearLeft = rearLeft;
    }

    public float getRearRight() {
        return rearRight;
    }

    public void setRearRight(float rearRight) {
        this.rearRight = rearRight;
    }

    @Override
    public String toString() {
        return "Tire{" +
                "id='" + id + '\'' +
                ", frontLeft=" + frontLeft +
                ", frontRight=" + frontRight +
                ", rearLeft=" + rearLeft +
                ", rearRight=" + rearRight +
                '}';
    }
}
