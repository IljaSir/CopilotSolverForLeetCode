class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        
        int m = queries.length;
        int n = nums.length;
        int[] ans = new int[m];
        int[][] q = new int[m][3];
        for (int i = 0; i < m; i++) {
            q[i][0] = queries[i][0];
            q[i][1] = queries[i][1];
            q[i][2] = i;
        }
        Arrays.sort(nums);
        Arrays.sort(q, (a, b) -> a[1] - b[1]);
        int idx = 0;
        Trie trie = new Trie();
        for (int i = 0; i < m; i++) {
            int x = q[i][0];
            int mVal = q[i][1];
            while (idx < n && nums[idx] <= mVal) {
                trie.insert(nums[idx]);
                idx++;
            }
            if (idx == 0) {
                ans[q[i][2]] = -1;
            } else {
                ans[q[i][2]] = trie.maxXor(x);
            }
        }
        return ans;
    }
    class TrieNode {
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[2];
        }
    }
    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        public void insert(int num) {
            TrieNode node = root;
            for (int i = 30; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.children[bit] == null) {
                    node.children[bit] = new TrieNode();
                }
                node = node.children[bit];
            }
        }
        public int maxXor(int num) {
            TrieNode node = root;
            int ans = 0;
            for (int i = 30; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.children[bit ^ 1] != null) {
                    ans |= (1 << i);
                    bit ^= 1;
                }
                node = node.children[bit];
            }
            return ans;
        }
    }
}