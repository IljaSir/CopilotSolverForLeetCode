class Solution {
public:
    long long findTheArrayConcVal(vector<int>& nums) {
        
        long long ans = 0;
        while (nums.size() > 1) {
            int a = nums[0];
            int b = nums[nums.size() - 1];
            ans += a * pow(10, floor(log10(b)) + 1) + b;
            nums.erase(nums.begin());
            nums.pop_back();
        }
        if (nums.size() == 1) {
            ans += nums[0];
        }
        return ans;
    }
};