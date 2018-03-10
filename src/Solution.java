import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

class Tree {
	Tree() {
	}

	Tree(int x, Tree l, Tree r) {
		this.x = x;
		this.l = l;
		this.r = r;
	}

	public int x;
	public Tree l;
	public Tree r;
}

public class Solution {
	public int solution(Tree T) {
		int result = 0;

		if (null == T)
			return -1;

		List<Integer> l = new ArrayList<>();

		preorder(l, T);

		int rootVal = l.get(0);
		for (Integer i : l) {
			if (i >= rootVal) {
				++result;
			}
		}
		return result;
	}

	public void preorder(List<Integer> l, Tree root) {
		if (root != null) {
			l.add(root.x);
			preorder(l, root.l);
			preorder(l, root.r);
		}
	}

	@Test
	public void x001() {
		assertEquals(-1, solution(null));
	}

	@Test
	public void t001() {
		assertEquals(1, solution(new Tree(5, null, null)));
	}

	@Test
	public void t002() {
		assertEquals(2, solution(new Tree(5, new Tree(3, null, null), new Tree(10, null, null))));
	}

	@Test
	public void t003() {
		assertEquals(4, solution(new Tree(5, new Tree(3, new Tree(20, null, null), new Tree(21, null, null)),
				new Tree(10, null, null))));
	}

	@Test
	public void t004() {
		assertEquals(4, solution(new Tree(5, new Tree(3, new Tree(20, null, null), new Tree(21, null, null)),
				new Tree(10, new Tree(1, null, null), null))));
	}

}