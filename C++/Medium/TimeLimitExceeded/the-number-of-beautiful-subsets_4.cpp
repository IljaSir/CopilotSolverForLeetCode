class Solution {
public:
    int beautifulSubsets(vector<int>& nums, int k) {
        
        int n = nums.size();
        int m = 1 << n;
        int ans = 0;
        for (int i = 1; i < m; i++) {
            bool flag = true;
            for (int j = 0; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    if ((i >> j & 1) && (i >> l & 1)) {
                        if (abs(nums[j] - nums[l]) == k) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (!flag) {
                    break;
                }
            }
            if (flag) {
                ans++;
            }
        }
        return ans;
    }
};