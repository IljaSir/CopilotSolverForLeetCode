class Solution {
public:
    int bestRotation(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> diff(n + 1);
        for (int i = 0; i < n; ++i) {
            int left = (i - nums[i] + 1 + n) % n;
            int right = (i + 1) % n;
            diff[left]--;
            diff[right]++;
            if (left > right) diff[0]--;
        }
        int best = -n, ans = 0, cur = 0;
        for (int i = 0; i < n; ++i) {
            cur += diff[i];
            if (cur > best) {
                best = cur;
                ans = i;
            }
        }
        return ans;
    }
};