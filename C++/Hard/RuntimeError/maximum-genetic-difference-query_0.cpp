class Solution {
public:
    vector<int> maxGeneticDifference(vector<int>& parents, vector<vector<int>>& queries) {
        
        int n = parents.size();
        vector<vector<int>> children(n);
        int root;
        for (int i = 0; i < n; ++i) {
            if (parents[i] == -1) {
                root = i;
            } else {
                children[parents[i]].push_back(i);
            }
        }
        vector<vector<int>> q(n);
        for (int i = 0; i < queries.size(); ++i) {
            q[queries[i][0]].push_back(i);
        }
        vector<int> ans(queries.size());
        vector<int> trie(2 * n);
        vector<int> cnt(2 * n);
        int trie_size = 1;
        function<void(int)> dfs = [&](int u) {
            for (auto& idx : q[u]) {
                int val = queries[idx][1];
                int cur = 0;
                for (int i = 17; i >= 0; --i) {
                    int bit = (val >> i) & 1;
                    if (cnt[trie[cur ^ bit]]) {
                        cur ^= bit;
                    }
                    cur = trie[cur];
                }
                ans[idx] = val ^ cur;
            }
            int t = trie_size++;
            for (int i = 17; i >= 0; --i) {
                int bit = (u >> i) & 1;
                trie[trie_size] = trie[t ^ bit];
                cnt[trie_size] = cnt[t ^ bit];
                trie[t ^ bit] = trie_size;
                t = trie_size++;
            }
            cnt[t] = 1;
            for (auto& v : children[u]) {
                dfs(v);
            }
            for (int i = 17; i >= 0; --i) {
                int bit = (u >> i) & 1;
                trie[t ^ bit] = trie[trie[t ^ bit]];
                t = trie[t];
            }
            --cnt[t];
        };
        dfs(root);
        return ans;
    }
};