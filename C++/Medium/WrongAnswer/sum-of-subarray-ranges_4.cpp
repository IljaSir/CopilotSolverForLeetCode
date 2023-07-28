class Solution {
public:
    long long subArrayRanges(vector<int>& nums) {
        
        long long result = 0;
        for (int i = 0; i < nums.size(); i++) {
            result += (long long)nums[i] * (i + 1) * (nums.size() - i);
        }
        return result;
    }
};