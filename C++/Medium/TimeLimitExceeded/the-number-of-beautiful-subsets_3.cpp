class Solution {
public:
    int beautifulSubsets(vector<int>& nums, int k) {
        
        int n = nums.size();
        int ans = 0;
        for (int mask = 0; mask < (1 << n); ++mask) {
            vector<int> v;
            for (int i = 0; i < n; ++i) {
                if (mask & (1 << i)) {
                    v.push_back(nums[i]);
                }
            }
            if (v.empty()) continue;
            bool ok = true;
            for (int i = 0; i < v.size(); ++i) {
                for (int j = i + 1; j < v.size(); ++j) {
                    if (abs(v[i] - v[j]) == k) {
                        ok = false;
                        break;
                    }
                }
                if (!ok) break;
            }
            if (ok) {
                ans += 1;
            }
        }
        return ans;
    }
};