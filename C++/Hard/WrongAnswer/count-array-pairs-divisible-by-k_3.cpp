class Solution {
public:
    long long countPairs(vector<int>& nums, int k) {
        
        unordered_map<int, int> m;
        long long res = 0;
        for (int num : nums) {
            res += m[k - num % k] % 1000000007;
            m[num % k]++;
        }
        return res % 1000000007;
    }
};