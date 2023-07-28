class Solution {
public:
    int jump(vector<int>& nums) {
        
        int n = nums.size();
        if (n == 1) return 0;
        int ans = 0;
        int i = 0;
        int maxReach = 0;
        while (i < n) {
            int j = i + 1;
            int maxNext = 0;
            while (j <= maxReach) {
                maxNext = max(maxNext, j + nums[j]);
                if (maxNext >= n - 1) {
                    return ans + 1;
                }
                j++;
            }
            i = maxReach + 1;
            maxReach = maxNext;
            ans++;
        }
        return ans;
    }
};