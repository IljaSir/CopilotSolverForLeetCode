class Solution {
public:
    string makeLargestSpecial(string s) {
        
        int n = s.size();
        vector<string> parts;
        for (int i = 0, j = 0, bal = 0; i < n; ++i) {
            bal += s[i] == '1' ? 1 : -1;
            if (bal == 0) {
                parts.push_back('1' + makeLargestSpecial(s.substr(j + 1, i - j - 1)) + '0');
                j = i + 1;
            }
        }
        sort(parts.begin(), parts.end(), greater<string>());
        string ans;
        for (string& part : parts)
            ans += part;
        return ans;
    }
};