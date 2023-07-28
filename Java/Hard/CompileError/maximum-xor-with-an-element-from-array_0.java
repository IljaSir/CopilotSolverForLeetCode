class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        
        Arrays.sort(nums);
        int n = queries.length;
        int[][] q = new int[n][3];
        for (int i = 0; i < n; i++) {
            q[i][0] = queries[i][0];
            q[i][1] = queries[i][1];
            q[i][2] = i;
        }
        Arrays.sort(q, (a, b) -> a[1] - b[1]);
        int[] ans = new int[n];
        int idx = 0;
        Trie trie = new Trie();
        for (int[] query : q) {
            int x = query[0], m = query[1], qid = query[2];
            while (idx < nums.length && nums[idx] <= m) {
                trie.insert(nums[idx++]);
            }
            if (idx == 0) {
                ans[qid] = -1;
            } else {
                ans[qid] = trie.getMaxXor(x);
            }
        }
        return ans;
    }
}
    }
}