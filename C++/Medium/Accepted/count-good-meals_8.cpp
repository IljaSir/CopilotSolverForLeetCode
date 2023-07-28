class Solution {
public:
    int countPairs(vector<int>& deliciousness) {
        
        const int mod = 1e9 + 7;
        int max = 0;
        for (auto &d : deliciousness) {
            max = std::max(max, d);
        }
        int max_sum = max * 2;
        std::unordered_map<int, int> m;
        int count = 0;
        for (auto &d : deliciousness) {
            for (int i = 1; i <= max_sum; i <<= 1) {
                int t = i - d;
                if (m.count(t)) {
                    count = (count + m[t]) % mod;
                }
            }
            m[d]++;
        }
        return count;
    }
};