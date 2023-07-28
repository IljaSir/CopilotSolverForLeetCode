class Solution {
public:
    int numFactoredBinaryTrees(vector<int>& arr) {
        
        sort(arr.begin(), arr.end());
        unordered_map<int, long> m;
        for (auto x : arr) m[x] = 1;
        long res = 0;
        for (auto x : arr) {
            for (auto y : arr) {
                if (x > y) continue;
                if (x < y && m.count(x * y)) m[x * y] += m[x] * m[y];
                if (x == y && m.count(x * y)) m[x * y] += m[x] * m[y] / 2;
            }
            res += m[x];
            res %= 1000000007;
        }
        return res;
    }
};