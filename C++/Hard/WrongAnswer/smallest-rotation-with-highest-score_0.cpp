class Solution {
public:
    int bestRotation(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> change(n, 0);
        for (int i = 0; i < n; ++i) {
            change[(i - nums[i] + 1 + n) % n] -= 1;
        }
        int best = -n, ans = 0, now = 0;
        for (int i = 0; i < n; ++i) {
            now += change[i];
            if (now > best) {
                best = now;
                ans = i;
            }
        }
        return ans;
    }
};