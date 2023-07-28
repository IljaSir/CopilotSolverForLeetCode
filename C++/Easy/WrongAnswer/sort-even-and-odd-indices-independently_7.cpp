class Solution {
public:
    vector<int> sortEvenOdd(vector<int>& nums) {
        
        // sort the odd indices in descending order
        sort(nums.begin() + 1, nums.end(), greater<int>());
        // sort the even indices in ascending order
        sort(nums.begin(), nums.end() - 1);
        return nums;
    }
};