package io.egen.repository;

import io.egen.entity.Alert;
import io.egen.entity.Readings;

public interface AlertRepository {
    void create(Alert alert);
}
