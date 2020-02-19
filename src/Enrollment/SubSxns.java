import java.util.*;

/*
 * Class that holds the sub-sections of a Class or Lecture
 */
public class SubSxns<T> {
	private LinkedList<T> subs;

	public SubSxns() {
		subs = new LinkedList<T>();
	}

	public void addSxn(T s) {
		subs.add(s);
	}

	public T getSxn(int i) {
		return subs.get(i);
	}

	@SuppressWarnings("unchecked")
	public T getSxn(String n) {
		for (int i = 0; i < subs.size(); i++) {
			if (subs.get(i) instanceof Class) {
				Class c = (Class)subs.get(i);
				
				if (c.getName() == n) {
					return (T)c;
				}
			} else if (subs.get(i) instanceof Lecture) {
				Lecture l = (Lecture)subs.get(i);
				
				if (l.getName() == n) {
					return (T)l;
				}
			}
		}

		return null;
	}


	public T getLastSxn() {
		return subs.get(subs.size() - 1);
	}

	public int size() {
		return subs.size();
	}
}
