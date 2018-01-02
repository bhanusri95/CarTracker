package io.egen.repository;

import io.egen.entity.Readings;

public interface ReadingRepository {
    Readings findOne(String id);

    Readings create(Readings r);

}
