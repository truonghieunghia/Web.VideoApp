package groupbase.thn.web.libs;
import java.util.ArrayList;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;
public class JDOModel {
	private PersistenceManager mPM ;
	private String mSortOrders;
	private String mFilter;
	private Integer mLimit;
	private Integer mPage;
	public PersistenceManager getPersistenceManager() {
		mPM = PMF.get().getPersistenceManager();
		return mPM;
	}

	public Transaction getTransaction() {
		return mPM.currentTransaction();
	}

	public void close() {
		mPM.close();
	}
	public synchronized <T> void Add(T obj) {
		getPersistenceManager();
		try {
			mPM.makePersistent(obj);
		} finally {
			mPM.close();
		}
	}
	public synchronized<T> void Update(T obj) {
		getPersistenceManager();
		Transaction tx = getTransaction();
		try {
			tx.begin();
			mPM.makePersistent(obj);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			mPM.close();
		}
	}
	public synchronized <T> void  Delete(Object key,Class<T> clazz) {
		getPersistenceManager();
		Transaction tx = getTransaction();
		T obj = (T) mPM.getObjectById(clazz, key);
		try {
			tx.begin();
			mPM.deletePersistent(obj);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			mPM.close();
		}
	}
	@SuppressWarnings("unchecked")
	public synchronized<T> List<T> getList(Class<T> clazz) {
		getPersistenceManager();
		Transaction tx = getTransaction();
		List<T> list = new ArrayList<T>();
		try {
			tx.begin();
			Query q = mPM.newQuery(clazz);
			this.setFilter(q);
			this.setOrders(q);
			this.setRange(q);
			list = (List<T>) q.execute();
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			mPM.close();
		}
		return list;

	}
	
	public synchronized <T>T getObject(Object key,Class<T> clazz) {
		getPersistenceManager();
		try {
			T obj = (T) mPM.getObjectById(clazz, key);
			mPM.close();
			return obj;
		} catch (Exception e) {
			return null;
		}
	}
	private void setOrders(Query q) {
		if (this.mSortOrders != null) {
			q.setOrdering(mSortOrders);
		}
	}

	private void setRange(Query q) {
		if (this.mPage != null && this.mLimit != null) {
			q.setRange(this.mPage*mLimit, this.mLimit*(this.mPage+1));
		}
	}

	protected void setFilter(Query q) {
		if (this.mFilter != null) {
			q.setFilter(mFilter);
		}
	}
	public void setFilter(String filter) {
		this.mFilter = filter;
	}
}
