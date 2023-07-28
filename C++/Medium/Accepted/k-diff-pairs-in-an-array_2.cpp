class Solution {
public:
    int findPairs(vector<int>& nums, int k) {
        
        if (nums.size() < 2) return 0;
        if (k < 0) return 0;
        sort(nums.begin(), nums.end());
        int i = 0;
        int j = 1;
        int count = 0;
        while (i < nums.size() && j < nums.size()) {
            if (i == j || nums[j] - nums[i] < k) {
                j++;
            } else if (nums[j] - nums[i] > k) {
                i++;
            } else {
                count++;
                i++;
                while (i < nums.size() && nums[i] == nums[i-1]) {
                    i++;
                }
            }
        }
        return count;
    }
};