class Solution {
public:
    int componentValue(vector<int>& nums, vector<vector<int>>& edges) {
        
        int n = nums.size();
        vector<int> parent(n);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (auto& edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int pu = find(parent, u);
            int pv = find(parent, v);
            if (pu != pv) {
                parent[pu] = pv;
            }
        }
        vector<int> cnt(n);
        for (int i = 0; i < n; i++) {
            int pi = find(parent, i);
            cnt[pi] += nums[i];
        }
        int sum = accumulate(nums.begin(), nums.end(), 0);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                if (cnt[i] == sum - cnt[i]) {
                    ans++;
                }
            }
        }
        return ans - 1;
    }
    int find(vector<int>& parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent, parent[i]);
    }
};