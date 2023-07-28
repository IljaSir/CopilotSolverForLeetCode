class Solution {
public:
    vector<int> splitIntoFibonacci(string num) {
        
        vector<int> ans;
        if (num.size() < 3) return ans;
        int n = num.size();
        for (int i = 1; i <= n / 2; ++i) {
            if (num[0] == '0' && i > 1) break;
            long x = stol(num.substr(0, i));
            if (x > INT_MAX) break;
            for (int j = 1; j <= (n - i) / 2; ++j) {
                if (num[i] == '0' && j > 1) break;
                long y = stol(num.substr(i, j));
                if (y > INT_MAX) break;
                ans = {int(x), int(y)};
                int k = i + j;
                while (k < n) {
                    long z = ans[ans.size() - 1] + ans[ans.size() - 2];
                    if (z > INT_MAX) break;
                    string s = to_string(z);
                    if (num.substr(k, s.size()) != s) break;
                    ans.push_back(int(z));
                    k += s.size();
                }
                if (k == n) return ans;
            }
        }
        return {};
    }
};