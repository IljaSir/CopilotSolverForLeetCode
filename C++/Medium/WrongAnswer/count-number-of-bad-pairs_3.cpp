class Solution {
public:
    long long countBadPairs(vector<int>& nums) {
        
        long long res = 0;
        unordered_map<long long, long long> m;
        for (int i = 0; i < nums.size(); ++i) {
            long long diff = nums[i] - i;
            res += m[diff];
            ++m[diff];
        }
        return res;
    }
};