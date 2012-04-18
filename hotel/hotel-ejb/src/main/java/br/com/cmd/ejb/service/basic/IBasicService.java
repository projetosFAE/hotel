package br.com.cmd.ejb.service.basic;

import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author leandro
 */
public interface IBasicService {

    void setParameters(Query q, String aux, List<Integer> list);

    String getParameters(String aux, List<Integer> list);
}
