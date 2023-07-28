class Solution {
public:
    int findShortestSubArray(vector<int>& nums) {
        
        unordered_map<int, int> count;
        unordered_map<int, int> first;
        int maxCount = 0;
        int minLen = nums.size();
        for (int i = 0; i < nums.size(); ++i) {
            if (count.find(nums[i]) == count.end()) {
                count[nums[i]] = 1;
                first[nums[i]] = i;
            } else {
                ++count[nums[i]];
            }
            if (count[nums[i]] > maxCount) {
                maxCount = count[nums[i]];
                minLen = i - first[nums[i]] + 1;
            } else if (count[nums[i]] == maxCount) {
                minLen = min(minLen, i - first[nums[i]] + 1);
            }
        }
        return minLen;
    }
};