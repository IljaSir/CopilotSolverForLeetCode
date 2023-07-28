class Solution {
public:
    long long kMirror(int k, int n) {
        
        long long ans = 0;
        vector<long long> v;
        v.push_back(1);
        for (int i = 2; i < k; ++i) {
            v.push_back(v.back() * k);
        }
        for (int i = 0; i < n; ++i) {
            ans += v[i];
        }
        return ans;
    }
};