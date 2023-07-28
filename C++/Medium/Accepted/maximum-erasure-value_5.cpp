class Solution {
public:
    int maximumUniqueSubarray(vector<int>& nums) {
        
        int sum = 0;
        int maxSum = 0;
        unordered_set<int> set;
        int i = 0;
        int j = 0;
        while (i < nums.size() && j < nums.size()) {
            if (set.find(nums[j]) == set.end()) {
                set.insert(nums[j]);
                sum += nums[j];
                j++;
                maxSum = max(maxSum, sum);
            } else {
                set.erase(nums[i]);
                sum -= nums[i];
                i++;
            }
        }
        return maxSum;
    }
};