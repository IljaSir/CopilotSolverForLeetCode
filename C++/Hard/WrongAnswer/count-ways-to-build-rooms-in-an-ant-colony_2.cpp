class Solution {
public:
    int waysToBuildRooms(vector<int>& prevRoom) {
        
        int n = prevRoom.size();
        vector<vector<int>> tree(n);
        for (int i = 1; i < n; ++i) {
            tree[prevRoom[i]].push_back(i);
        }
        vector<int> num(n, 0);
        dfs(tree, num, 0);
        long long ans = 1;
        for (int i = 1; i < n; ++i) {
            ans = ans * num[i] % 1000000007;
        }
        return ans;
    }
    void dfs(vector<vector<int>>& tree, vector<int>& num, int root) {
        num[root] = 1;
        for (int child : tree[root]) {
            dfs(tree, num, child);
            num[root] += num[child];
        }
    }
};