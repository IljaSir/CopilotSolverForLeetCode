class Solution {
public:
    long long zeroFilledSubarray(vector<int>& nums) {
        
        long long res = 0;
        int n = nums.size();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                res += (long long)count * (count + 1) / 2;
                count = 0;
            }
        }
        res += (long long)count * (count + 1) / 2;
        return res;
    }
};