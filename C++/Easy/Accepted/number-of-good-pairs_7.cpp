class Solution {
public:
    int numIdenticalPairs(vector<int>& nums) {
        
        unordered_map<int, int> m;
        for (int n : nums) {
            m[n]++;
        }
        int res = 0;
        for (auto it : m) {
            res += (it.second * (it.second - 1)) / 2;
        }
        return res;
    }
};