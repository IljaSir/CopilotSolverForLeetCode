class Solution {
public:
    long long zeroFilledSubarray(vector<int>& nums) {
        
        long long res = 0;
        int n = nums.size();
        int i = 0;
        int j = 0;
        int zeroCount = 0;
        while (j < n) {
            if (nums[j] == 0) {
                zeroCount++;
            }
            while (zeroCount > 1) {
                if (nums[i] == 0) {
                    zeroCount--;
                }
                i++;
            }
            res += j - i + 1;
            j++;
        }
        return res;
    }
};