class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int ans = 0;
        int diff = INT_MAX;
        for (int i = 0; i < n; ++i) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    ++j;
                } else {
                    --k;
                }
                if (abs(sum - target) < diff) {
                    ans = sum;
                    diff = abs(sum - target);
                }
            }
        }
        return ans;
    }
};