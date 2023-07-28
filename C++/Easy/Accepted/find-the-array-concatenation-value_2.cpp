class Solution {
public:
    long long findTheArrayConcVal(vector<int>& nums) {
        
        long long ans = 0;
        while (nums.size() > 1) {
            ans += nums[0] * pow(10, int(log10(nums.back())) + 1) + nums.back();
            nums.erase(nums.begin());
            nums.pop_back();
        }
        return ans + (nums.size() ? nums[0] : 0);
    }
};