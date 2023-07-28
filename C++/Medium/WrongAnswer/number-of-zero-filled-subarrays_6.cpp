class Solution {
public:
    long long zeroFilledSubarray(vector<int>& nums) {
        
        long long result = 0;
        int i = 0;
        int j = 0;
        int n = nums.size();
        int count = 0;
        while (j < n) {
            if (nums[j] == 0) {
                count++;
            }
            while (count > 1) {
                if (nums[i] == 0) {
                    count--;
                }
                i++;
            }
            result += j - i + 1;
            j++;
        }
        return result;
    }
};