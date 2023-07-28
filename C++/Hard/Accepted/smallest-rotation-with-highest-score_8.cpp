class Solution {
public:
    int bestRotation(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> diff(n+1, 0);
        for(int i = 0; i < n; i++) {
            diff[(i - nums[i] + 1 + n) % n]--;
            diff[(i + 1) % n]++;
            if(i - nums[i] + 1 < 0) diff[0]--;
        }
        int best = -n, ans = 0, cur = 0;
        for(int i = 0; i < n; i++) {
            cur += diff[i];
            if(cur > best) {
                best = cur;
                ans = i;
            }
        }
        return ans;
    }
};