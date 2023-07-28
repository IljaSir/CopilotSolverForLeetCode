class Solution {
public:
    int largestComponentSize(vector<int>& nums) {
        
        int n = nums.size();
        int res = 1;
        vector<int> parent(n, 0);
        for (int i = 0; i < n; ++i) parent[i] = i;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (gcd(nums[i], nums[j]) > 1) {
                    unionSet(parent, i, j);
                }
            }
        }
        unordered_map<int, int> m;
        for (int i = 0; i < n; ++i) {
            int p = findSet(parent, i);
            ++m[p];
            res = max(res, m[p]);
        }
        return res;
    }
    
    int findSet(vector<int>& parent, int i) {
        if (parent[i] == i) return i;
        parent[i] = findSet(parent, parent[i]);
        return parent[i];
    }
};