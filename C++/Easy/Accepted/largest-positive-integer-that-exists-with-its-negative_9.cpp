class Solution {
public:
    int findMaxK(vector<int>& nums) {
        
        // sort the array
        sort(nums.begin(), nums.end());
        // find the largest positive integer k such that -k also exists in the array
        int k = -1;
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] > 0) {
                if (binary_search(nums.begin(), nums.end(), -nums[i])) {
                    k = nums[i];
                }
            }
        }
        return k;
    }
    int largestMagicalString(string s) {
        // convert the string to an array of integers
        vector<int> nums(s.size());
        for (int i = 0; i < s.size(); ++i) {
            nums[i] = s[i] - '0';
        }
        // find the largest positive integer k such that -k also exists in the array
        int k = findMaxK(nums);
        // return the positive integer k
        return k;
    }
};