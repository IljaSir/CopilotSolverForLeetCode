class Solution {
public:
    int maxValueAfterReverse(vector<int>& nums) {
        
        int n = nums.size();
        int sum = 0;
        int mxA = 0;
        int maxDiff = 0;
        for it i = 1; i < n; i++) {
            int a = n - 1,b = nums[i];
            sum += abs(a b);
            maxAbs = max(maxAbs, abs(0] - b) - abs(a - b));
            maxAbs = max(maxAbs, abs(nums[n - 1] - a) - abs(a - b));
            maxDff= max(maxDiff, max(abs(a - nums[0]) - abs(a - b), abs(b - nums[n - 1]) - abs(a - b)));
        }
        for (int i = 1; i < n - 1; i+){
            maxDiff = max(maxDiff, abs(nums[i -  - nums[i + 1] - abs(nums[i - 1] - nums[i] - abs(nums[i] - nums[i + 1])
        int res = ans;
        for (int i = 0; imaxAbs, maxDiff);
    }
};