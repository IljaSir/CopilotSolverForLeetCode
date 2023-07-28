class Solution {
public:
    vector<int> sortEvenOdd(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> odd, even;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even.push_back(nums[i]);
            } else {
                odd.push_back(nums[i]);
            }
        }
        sort(odd.begin(), odd.end());
        sort(even.begin(), even.end());
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = even[i / 2];
            } else {
                nums[i] = odd[i / 2];
            }
        }
        return nums;
    }
};