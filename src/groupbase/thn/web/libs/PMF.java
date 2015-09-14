package groupbase.thn.web.libs;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public class PMF {
	private static final PersistenceManagerFactory pmfInstance = JDOHelper
            .getPersistenceManagerFactory("transactions-optional");

public static PersistenceManagerFactory get() {
    return pmfInstance;
}
}
