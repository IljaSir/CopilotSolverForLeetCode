class Solution {
public:
    long long findTheArrayConcVal(vector<int>& nums) {
        
        long long ans = 0;
        while (nums.size() > 0) {
            if (nums.size() == 1) {
                ans += nums[0];
                nums.erase(nums.begin());
            } else {
                int first = nums[0];
                int last = nums[nums.size() - 1];
                ans += (long long)first * pow(10, (int)log10(last) + 1) + last;
                nums.erase(nums.begin());
                nums.erase(nums.end() - 1);
            }
        }
        return ans;
    }
};