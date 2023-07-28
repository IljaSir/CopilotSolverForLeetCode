class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        
        vector<int> sortedNums = nums;
        sort(sortedNums.begin(), sortedNums.end());
        int start = 0, end = nums.size() - 1;
        while (start < end && nums[start] == sortedNums[start]) {
            ++start;
        }
        while (end > start && nums[end] == sortedNums[end]) {
            --end;
        }
        return end - start + 1;
    }
};