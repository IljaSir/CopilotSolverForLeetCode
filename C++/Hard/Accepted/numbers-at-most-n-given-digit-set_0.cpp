class Solution {
public:
    int atMostNGivenDigitSet(vector<string>& digits, int n) {
        
        string s = to_string(n);
        int k = s.size();
        int ans = 0;
        for (int i = 1; i < k; ++i) {
            ans += pow(digits.size(), i);
        }
        for (int i = 0; i < k; ++i) {
            bool same = false;
            for (auto &d : digits) {
                if (d[0] < s[i]) {
                    ans += pow(digits.size(), k - i - 1);
                } else if (d[0] == s[i]) {
                    same = true;
                }
            }
            if (!same) {
                return ans;
            }
        }
        return ans + 1;
    }
};