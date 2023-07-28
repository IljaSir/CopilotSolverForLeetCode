class Solution {
public:
    long long subArrayRanges(vector<int>& nums) {
        
        long long sum = 0;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            sum += nums[i] * (i + 1) * (n - i);
        }
        return sum;
    }
};