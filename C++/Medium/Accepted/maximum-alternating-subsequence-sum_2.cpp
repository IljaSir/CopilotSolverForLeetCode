class Solution {
public:
    long long maxAlternatingSum(vector<int>& nums) {
        
        long long odd = 0, even = 0;
        for (int num : nums) {
            odd = max(odd, even + num);
            even = odd - num;
        }
        return odd;
    }
};