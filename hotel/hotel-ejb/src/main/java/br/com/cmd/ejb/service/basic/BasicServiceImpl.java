package br.com.cmd.ejb.service.basic;

import br.com.cmd.hotel.;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Alex Porto
 */
public class BasicServiceImpl {

    /**
     * Method to set parameters
     * @param aux string to explicit what's the text before parameter.
     * @param list
     * @return 
     */
    public void setParameters(Query q, String aux, List<Integer> list) {
        if (list != null) {
            Integer index = 0;

            for (Integer id : list) {
                q.setParameter(aux + index, id);
                index++;
            }
        }
    }

    /**
     * Method to get parameters
     * @param aux string to explicit what is the text before parameter.
     * @param list
     * @return 
     */
    public String getParameters(String aux, List<Integer> list) {
        StringBuilder st = new StringBuilder();
        st.append("(");
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                st.append("#");
                st.append(aux);
                st.append(i);
            } else {
                st.append(", #");
                st.append(aux);
                st.append(i);
            }

        }
        st.append(")");
        return st.toString();
    }
}
