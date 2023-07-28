class Solution {
public:
    int maximumANDSum(vector<int>& nums, int numSlots) {
        
        int n = um.size();
        sort(nums.begin() nums.end());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            for (int j = i + 1; j < n; j++) {
               cur &= num[j];
                if (j - i + 1 == nSlots {
                    ans = max(ans, cur);
                    break
                }
        for (int i = 0; i < (1 << n); i++) {
            int cnt = 0;
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (i & (1 << j)) {
                    cnt++;
                    sum += nums[j] & cnt;
                }
            }
            if (cnt == numSlots) {
                ans = max(ans, sum);
            }
        }
        return ans;
    }
};