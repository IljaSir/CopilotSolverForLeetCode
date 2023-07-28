class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        
        int n = nums.length;
        int m = queries.length;
        int[] ans = new int[m];
        Arrays.sort(nums);
        int[][] q = new int[m][3];
        for (int i = 0; i < m; i++) {
            q[i][0] = queries[i][0];
            q[i][1] = queries[i][1];
            q[i][2] = i;
        }
        Arrays.sort(q, (a, b) -> a[1] - b[1]);
        int idx = 0;
        Trie trie = new Trie();
        for (int i = 0; i < m; i++) {
            while (idx < n && nums[idx] <= q[i][1]) {
                trie.insert(nums[idx]);
                idx++;
            }
            if (idx == 0) {
                ans[q[i][2]] = -1;
            } else {
                ans[q[i][2]] = trie.query(q[i][0]);
            }
        }
        return ans;
    }
}
    }
}