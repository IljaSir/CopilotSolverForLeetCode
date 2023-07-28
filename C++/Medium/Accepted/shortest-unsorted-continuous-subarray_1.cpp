class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> sorted(nums);
        sort(sorted.begin(), sorted.end());
        int i = 0, j = n - 1;
        while (i < n && nums[i] == sorted[i]) i++;
        while (j >= 0 && nums[j] == sorted[j]) j--;
        return j - i >= 0 ? j - i + 1 : 0;
    }
};