package com.valdemar.storytail.service;

import com.valdemar.storytail.exceptions.NewTaleCreationException;
import com.valdemar.storytail.model.*;

import java.util.List;

public interface TaleService {
    NearTales findNearTales(Location location);

    Tale findTale(String taleId);

    Tale createNewTale(NewTale tale, String userId) throws NewTaleCreationException;
}
