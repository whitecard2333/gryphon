package com.oraclecube.whitecard.service.data;

import com.oraclecube.whitecard.core.data.entity.BaseEntity;
import com.oraclecube.whitecard.core.data.repository.BaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Abstract service as DAO
 * Created by zhouhu on 21/4/2017.
 */
public abstract class BaseDataService<R extends BaseRepository<T, ID>,T extends BaseEntity, ID extends Serializable> {
    private static final Logger logger = LoggerFactory.getLogger(BaseDataService.class);
    public abstract R getRepository();
}
