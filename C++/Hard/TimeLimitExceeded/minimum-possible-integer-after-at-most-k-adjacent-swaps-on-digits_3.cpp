class Solution {
public:
    string minInteger(string num, int k) {
        
        int n = num.size();
        vector<int> v(n, 0);
        for (int i = 0; i < n; ++i) {
            v[i] = num[i] - '0';
        }
        for (int i = 0; i < n; ++i) {
            int min_i = i;
            for (int j = i + 1; j < n && j - i <= k; ++j) {
                if (v[j] < v[min_i]) {
                    min_i = j;
                }
            }
            k -= (min_i - i);
            for (int j = min_i; j > i; --j) {
                swap(v[j], v[j - 1]);
            }
        }
        string ret;
        for (int i = 0; i < n; ++i) {
            ret += (v[i] + '0');
        }
        return ret;
    }
};