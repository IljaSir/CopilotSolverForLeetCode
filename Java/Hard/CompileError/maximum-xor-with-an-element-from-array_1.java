class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        
        int n = nums.length;
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = -1;
        }
        Trie root = new Trie();
        for (int i = 0; i < n; i++) {
            root.insert(nums[i]);
        }
        for (int i = 0; i < m; i++) {
            ans[i] = root.maxXor(queries[i][0], queries[i][1]);
        }
        return ans;
    }
}
    }
}