class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        
        int n = nums.size();
        int ans = 0;
        int minDiff = INT_MAX;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = abs(sum - target);
                if (diff < minDiff) {
                    ans = sum;
                    minDiff = diff;
                }
                if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }
};