class Solution {
public:
    int countPairs(vector<int>& deliciousness) {
        
        unordered_map<int, int> m;
        int res = 0;
        for (int i = 0; i < deliciousness.size(); ++i) {
            for (int j = 0; j <= 21; ++j) {
                int t = 1 << j;
                res = (res + m[t - deliciousness[i]]) % 1000000007;
            }
            ++m[deliciousness[i]];
        }
        return res;
    }
};