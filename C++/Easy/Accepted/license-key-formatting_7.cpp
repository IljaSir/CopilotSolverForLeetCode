class Solution {
public:
    string licenseKeyFormatting(string s, int k) {
        
        string ans;
        for (int i = s.size() - 1; i >= 0; --i) {
            if (s[i] != '-') {
                ans.push_back(toupper(s[i]));
                if (ans.size() % (k + 1) == k) {
                    ans.push_back('-');
                }
            }
        }
        if (!ans.empty() && ans.back() == '-') {
            ans.pop_back();
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};