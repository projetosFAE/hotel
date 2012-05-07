package domain;

import java.io.Serializable;

/**
 *
 * @author Rodrigo Rocha
 */
public interface Persistent extends Serializable {

     <T extends Serializable> T getId();

    void setId(Serializable id);
}
