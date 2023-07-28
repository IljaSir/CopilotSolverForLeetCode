class Solution {
public:
    int minOperations(vector<int>& nums, vector<int>& numsDivide) {
        
        map<int, int> m;
        for (auto &n : nums) m[n]++;
        int res = 0;
        for (auto &n : numsDivide) {
            int t = n;
            for (auto it = m.rbegin(); it != m.rend(); ++it) {
                int k = it->first;
                while (t % k == 0 && it->second > 0) {
                    t /= k;
                    it->second--;
                }
            }
            if (t > 1) return -1;
        }
        for (auto &it : m) res += it.second;
        return res;
    }
};