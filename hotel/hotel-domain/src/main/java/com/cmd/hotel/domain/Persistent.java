package com.cmd.hotel.domain;

import java.io.Serializable;

/**
 *
 * @author Alex Porto
 */
public interface Persistent extends Serializable {

     <T extends Serializable> T getId();

    void setId(Serializable id);
}
