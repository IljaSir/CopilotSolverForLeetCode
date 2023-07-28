class Solution {
public:
    long long findTheArrayConcVal(vector<int>& nums) {
        
        long long ans = 0;
        while (nums.size() > 1) {
            long long a = nums[0], b = nums[nums.size() - 1];
            int cnt = 0;
            while (a >= 10) {
                a /= 10;
                cnt++;
            }
            while (cnt--) {
                b *= 10;
            }
            ans += a + b;
            nums.erase(nums.begin());
            nums.erase(nums.end() - 1);
        }
        if (nums.size() == 1) {
            ans += nums[0];
        }
        return ans;
    }
};