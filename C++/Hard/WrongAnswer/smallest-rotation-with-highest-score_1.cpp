class Solution {
public:
    int bestRotation(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> change(n);
        for (int i = 0; i < n; ++i) {
            change[(i - nums[i] + 1 + n) % n] -= 1;
        }
        int best = 0;
        int best_i = 0;
        int now = 0;
        for (int i = 0; i < n; ++i) {
            now += change[i];
            if (now > best) {
                best = now;
                best_i = i;
            }
        }
        return best_i;
    }
};