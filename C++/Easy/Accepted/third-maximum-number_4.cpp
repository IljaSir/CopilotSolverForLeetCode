class Solution {
public:
    int thirdMax(vector<int>& nums) {
        
        int n = nums.size();
        long long first = LLONG_MIN, second = LLONG_MIN, third = LLONG_MIN;
        for (int i = 0; i < n; i++) {
            if (nums[i] == first || nums[i] == second || nums[i] == third) continue;
            if (nums[i] > first) {
                third = second;
                second = first;
                first = nums[i];
            } else if (nums[i] > second) {
                third = second;
                second = nums[i];
            } else if (nums[i] > third) {
                third = nums[i];
            }
        }
        return third == LLONG_MIN ? first : third;
    }
};