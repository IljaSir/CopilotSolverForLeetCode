class Solution {
public:
    long long minimalKSum(vector<int>& nums, int k) {
        
        long long sum = 0;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
        }
        int last = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] - last > 1) {
                int add = min(nums[i] - last - 1, k);
                sum += add * (last + 1) + (add * (add - 1)) / 2;
                k -= add;
                if (k == 0) {
                    return sum;
                }
            }
            last = nums[i];
        }
        sum += k * (last + 1) + (k * (k - 1)) / 2;
        return sum;
    }
};