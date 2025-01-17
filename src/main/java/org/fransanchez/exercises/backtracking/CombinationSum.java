package org.fransanchez.exercises.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(final int[] candidates, final int target) {
        final var ans = new ArrayList<List<Integer>>();
        backtrack(new ArrayList<>(), ans, 0, candidates, target);
        return ans;
    }

    private void backtrack(final List<Integer> curr, final List<List<Integer>> ans, final int index, final int[] candidates, final int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        } else if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            final var candidate = candidates[i];
            if (candidate <= target) {
                curr.add(candidate);
                backtrack(curr, ans, i, candidates, target - candidate);
                curr.removeLast();
            }
        }
    }

    private void backtrack2(final List<Integer> curr, final int index, final int[] candidates, final int target, final List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        } else if (index >= candidates.length || target < 0) {
            return;
        }

        // Take next number
        curr.add(candidates[index]);
        backtrack2(curr, index, candidates, target - candidates[index], ans);

        // Don't take next number
        curr.removeLast();
        backtrack2(curr, index + 1, candidates, target, ans);
    }
}
