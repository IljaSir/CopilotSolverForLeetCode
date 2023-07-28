class Solution {
public:
    int squareFreeSubsets(vector<int>& nums) {
        
        int n = nums.size();
        int mod = 1e9+7;
        vector<int> cnt(31, 0);
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        int res = 0;
        for (int i = 1; i < (1<<n); i++) {
            int tmp = 1;
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i & (1<<j)) {
                    cnt++;
                    tmp *= nums[j];
                }
            }
            int num = 0;
            for (int j = 2; j*j <= tmp; j++) {
                if (tmp % (j*j) == 0) {
                    num++;
                    break;
                }
            }
            if (num == 0) {
                if (cnt % 2 == 0) {
                    res -= (1<<cnt);
                } else {
                    res += (1<<cnt);
                }
            }
        }
        return res;
    }
};