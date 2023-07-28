class Solution {
public:
    int countPairs(vector<int>& deliciousness) {
        
        long n = deliciousness.size();
        long mod = 1000000007;
        long sum = 0;
        unordered_map<int, int> m;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= 21; ++j) {
                int x = pow(2, j) - deliciousness[i];
                if (m.find(x) != m.end()) {
                    sum = (sum + m[x]) % mod;
                }
            }
            m[deliciousness[i]]++;
        }
        return sum;
    }
};