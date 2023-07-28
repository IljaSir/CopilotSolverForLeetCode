class Solution {
public:
    int countPairs(vector<int>& deliciousness) {
        
        map<int, int> m;
        int res = 0;
        int mod = 1e9 + 7;
        for (auto d : deliciousness) {
            int sum = 1;
            for (int i = 0; i <= 21; i++) {
                if (m.count(sum - d)) {
                    res += m[sum - d];
                    res %= mod;
                }
                sum <<= 1;
            }
            m[d]++;
        }
        return res;
    }
};