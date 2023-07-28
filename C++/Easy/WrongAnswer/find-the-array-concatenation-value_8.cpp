class Solution {
public:
    long long findTheArrayConcVal(vector<int>& nums) {
        
        long long ans = 0;
        while (nums.size() > 1) {
            long long a = nums[0];
            long long b = nums.back();
            int len = 1;
            while (a >= 10) {
                a /= 10;
                len++;
            }
            while (b >= 10) {
                b /= 10;
                len++;
            }
            ans += a * pow(10, len) + b;
            nums.erase(nums.begin());
            nums.pop_back();
        }
        return ans + nums[0];
    }
};