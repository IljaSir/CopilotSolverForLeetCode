class Solution {
public:
    int jump(vector<int>& nums) {
        
        int n = nums.size();
        if (n <= 1) return 0;
        int maxJump = nums[0];
        int steps = 1;
        int currentJump = nums[0];
        for (int i = 1; i < n; i++) {
            if (i == n-1) return steps;
            maxJump = max(maxJump, i + nums[i]);
            currentJump--;
            if (currentJump == 0) {
                steps++;
                currentJump = maxJump - i;
            }
        }
        return steps;
    }
};