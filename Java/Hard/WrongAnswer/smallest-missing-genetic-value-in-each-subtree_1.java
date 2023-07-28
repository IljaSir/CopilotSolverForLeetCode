class Solution {
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        
        int n = parents.length;
        List<Integer>[] children = new List[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            if (parents[i] != -1) {
                children[parents[i]].add(i);
            }
        }
        int[] ans = new int[n];
        boolean[] seen = new boolean[100001];
        for (int num : nums) {
            seen[num] = true;
        }
        for (int i = 0; i < n; i++) {
            if (seen[nums[i]]) {
                ans[i] = findNext(seen, nums[i]);
            } else {
                ans[i] = nums[i];
            }
        }
        return ans;
    }
    
    private int findNext(boolean[] seen, int num) {
        for (int i = num + 1; i < seen.length; i++) {
            if (!seen[i]) {
                return i;
            }
        }
        return 1;
    }
}