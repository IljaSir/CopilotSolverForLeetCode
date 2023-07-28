class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        
        vector<vector<int>> result;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                int start = j + 1;
                int end = nums.size() - 1;
                while (start < end) {
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum == target) {
                        result.push_back(vector<int>{nums[i], nums[j], nums[start], nums[end]});
                        while (start < end && nums[start] == nums[start + 1]) start++;
                        while (start < end && nums[end] == nums[end - 1]) end--;
                        start++;
                        end--;
                    } else if (sum > target) {
                        end--;
                    } else {
                        start++;
                    }
                }
                while (j + 1 < nums.size() && nums[j + 1] == nums[j]) j++;
            }
            while (i + 1 < nums.size() && nums[i + 1] == nums[i]) i++;
        }
        return result;
    }
};