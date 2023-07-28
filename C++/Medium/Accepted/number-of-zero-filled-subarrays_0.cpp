class Solution {
public:
    long long zeroFilledSubarray(vector<int>& nums) {
        
        long long result = 0;
        long long count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                result += count * (count + 1) / 2;
                count = 0;
            }
        }
        result += count * (count + 1) / 2;
        return result;
    }
};