class Solution {
public:
    int largestComponentSize(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> p(n);
        for (int i = 0; i < n; ++i) p[i] = i;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (__gcd(nums[i], nums[j]) > 1) {
                    int pi = find(p, i);
                    int pj = find(p, j);
                    if (pi != pj) p[pi] = pj;
                }
            }
        }
        unordered_map<int, int> m;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int pi = find(p, i);
            ++m[pi];
            res = max(res, m[pi]);
        }
        return res;
    }
};