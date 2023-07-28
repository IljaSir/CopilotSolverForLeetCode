class Solution {
public:
    int tupleSameProduct(vector<int>& nums) {
        
        unordered_map<int, int> m;
        int res = 0, n = nums.size();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                res += m[nums[i] * nums[j]]++ * 8;
            }
        }
        return res;
    }
};