class Solution {
public:
    string getPermutation(int n, int k) {
        
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        vector<int> v;
        for (int i = 1; i <= n; i++) {
            v.push_back(i);
        }
        string ret;
        k--;
        while (n > 0) {
            int i = k / (f / n);
            ret += to_string(v[i]);
            v.erase(v.begin() + i);
            k %= f / n;
            f /= n;
            n--;
        }
        return ret;
    }
};