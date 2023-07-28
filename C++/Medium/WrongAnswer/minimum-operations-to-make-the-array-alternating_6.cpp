class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> odd(n), even(n);
        odd[0] = 0;
        even[0] = 1;
        for (int i = 1; i < n; i++) {
            odd[i] = even[i] = 0x7fffffff;
            if (nums[i - 1] != nums[i]) {
                odd[i] = odd[i - 1];
                even[i] = even[i - 1] + 1;
            }
            if (nums[i - 1] != nums[i] - 1) {
                odd[i] = min(odd[i], even[i - 1]);
                even[i] = min(even[i], odd[i - 1] + 1);
            }
        }
        return min(odd[n - 1], even[n - 1]);
    }
};