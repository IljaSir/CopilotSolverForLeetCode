class Solution {
public:
    int minimizeSum(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> left(n, INT_MAX);
        vector<int> right(n, INT_MAX);
        for(int i = 1; i < n; i++){
            left[i] = min(left[i - 1], nums[i - 1]);
            right[n - i - 1] = min(right[n - i], nums[n - i]);
        }
        int ans = INT_MAX;
        for(int i = 1; i < n - 1; i++){
            ans = min(ans, max(nums[i] - left[i], right[i] - nums[i]));
        }
        return ans;
    }
    int minDifference(vector<int>& nums) {
        if(nums.size() <= 4) return 0;
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int ans = INT_MAX;
        for(int i = 0; i < 4; i++){
            ans = min(ans, nums[n - 4 + i] - nums[i]);
        }
        return ans;
    }
    int minScore(vector<int>& nums) {
        int n = nums.size();
        if(n <= 4) return 0;
        int sum = 0;
        for(int i = 1; i < n; i++){
            sum += abs(nums[i] - nums[i - 1]);
        }
        return sum - minDifference(nums) - minimizeSum(nums);
    }
};