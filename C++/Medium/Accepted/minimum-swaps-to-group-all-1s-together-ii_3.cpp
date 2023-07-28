class Solution {
public:
    int minSwaps(vector<int>& nums) {
        
        int n = nums.size();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) cnt++;
        }
        int one = 0;
        for (int i = 0; i < cnt; i++) {
            if (nums[i] == 1) one++;
        }
        int ans = cnt - one;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) one--;
            if (nums[(i + cnt) % n] == 1) one++;
            ans = min(ans, cnt - one);
        }
        return ans;
    }
};