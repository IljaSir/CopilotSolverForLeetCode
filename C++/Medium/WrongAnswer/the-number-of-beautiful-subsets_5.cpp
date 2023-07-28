class Solution {
public:
    int beautifulSubsets(vector<int>& nums, int k) {
        
        int n = nums.size();
        int res = 0;
        for (int i = 1; i < (1 << n); i++) {
            int cnt = 0;
            bool ok = true;
            for (int j = 0; j < n; j++) {
                if (i & (1 << j)) {
                    cnt++;
                    for (int l = j + 1; l < n; l++) {
                        if (i & (1 << l) && abs(nums[j] - nums[l]) == k) {
                            ok = false;
                            break;
                        }
                    }
                }
                if (!ok) break;
            }
            if (ok) res += cnt;
        }
        return res;
    }
};