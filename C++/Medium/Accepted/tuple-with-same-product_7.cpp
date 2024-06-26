class Solution {
public:
    int tupleSameProduct(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        unordered_map<int, int> m;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                m[nums[i] * nums[j]]++;
            }
        }
        for (auto i : m) {
            res += i.second * (i.second - 1) * 4;
        }
        return res;
    }
};