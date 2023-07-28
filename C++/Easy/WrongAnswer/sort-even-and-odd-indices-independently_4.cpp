class Solution {
public:
    vector<int> sortEvenOdd(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> odd, even;
        for (int i = 0; i < n; i++) {
            if (i % 2) {
                odd.push_back(nums[i]);
            } else {
                even.push_back(nums[i]);
            }
        }
        sort(odd.begin(), odd.end(), greater<int>());
        sort(even.begin(), even.end());
        int i = 0;
        for (int x : even) {
            nums[i++] = x;
        }
        for (int x : odd) {
            nums[i++] = x;
        }
        return nums;
    }
};