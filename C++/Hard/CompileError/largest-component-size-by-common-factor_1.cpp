class Solution {
public:
    int largestComponentSize(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> parent(n);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (gcd(nums[i], nums[j]) > 1) {
                    unionSet(i, j, parent);
                }
            }
        }
        unordered_map<int, int> m;
        int res = 1;
        for (int i = 0; i < n; i++) {
            res = max(res, ++m[findSet(i, parent)]);
        }
        return res;
    }
};