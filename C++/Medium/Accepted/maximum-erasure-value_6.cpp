class Solution {
public:
    int maximumUniqueSubarray(vector<int>& nums) {
        
        int result = 0;
        int sum = 0;
        unordered_set<int> set;
        int i = 0;
        int j = 0;
        while (j < nums.size()) {
            if (set.find(nums[j]) == set.end()) {
                set.insert(nums[j]);
                sum += nums[j];
                result = max(result, sum);
                j++;
            } else {
                sum -= nums[i];
                set.erase(nums[i]);
                i++;
            }
        }
        return result;
    }
};