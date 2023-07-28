class Solution {
public:
    int bestRotation(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> diff(n);
        for (int i = 0; i < n; i++) {
            diff[(i - nums[i] + 1 + n) % n]--;
        }
        int best = 0, score = 0;
        for (int i = 0; i < n; i++) {
            score += diff[i];
            if (score > best) {
                best = score;
                k = i;
            }
        }
        return k;
    }
};