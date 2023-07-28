class Solution {
public:
    int beautifulSubsets(vector<int>& nums, int k) {
        
        int n = nums.size();
        int res = 0;
        for (int i = 0; i < (1 << n); i++) {
            bool ok = true;
            for (int j = 0; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    if ((i & (1 << j)) && (i & (1 << l)) && abs(nums[j] - nums[l]) == k) {
                        ok = false;
                    }
                }
            }
            if (ok) {
                res++;
            }
        }
        return res;
    }
};