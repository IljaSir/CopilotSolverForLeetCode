class Solution {
public:
    int largestPerimeter(vector<int>& nums) {
        
        // sort the array in descending order
        sort(nums.begin(), nums.end(), greater<int>());
        int n = nums.size();
        // iterate through the array
        for (int i = 0; i < n - 2; i++) {
            // check if the triangle is valid
            if (nums[i] < (nums[i+1] + nums[i+2])) {
                return nums[i] + nums[i+1] + nums[i+2];
            }
        }
        // return 0 if no valid triangle is found
        return 0;
    }
};