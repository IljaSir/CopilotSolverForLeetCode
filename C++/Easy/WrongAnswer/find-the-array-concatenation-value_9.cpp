class Solution {
public:
    long long findTheArrayConcVal(vector<int>& nums) {
        
        long long ans = 0;
        while (nums.size() > 1) {
            int a = nums[0], b = nums[nums.size()-1];
            long long c = 0;
            while (a > 0) {
                c = c * 10 + a % 10;
                a /= 10;
            }
            while (b > 0) {
                c = c * 10 + b % 10;
                b /= 10;
            }
            ans += c;
            nums.erase(nums.begin());
            nums.erase(nums.end()-1);
        }
        if (nums.size() == 1) ans += nums[0];
        return ans;
    }
};