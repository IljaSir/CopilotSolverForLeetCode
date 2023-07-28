class Solution {
public:
    string makeLargestSpecial(string s) {
        
        string ans = "";
        int i = 0;
        int j = 0;
        int c = 0;
        vector<string> v;
        while (i < s.size()) {
            if (s[i] == '1') c++;
            else c--;
            if (c == 0) {
                v.push_back('1' + makeLargestSpecial(s.substr(j + 1, i - j - 1)) + '0');
                j = i + 1;
            }
            i++;
        }
        sort(v.begin(), v.end());
        for (i = v.size() - 1; i >= 0; i--) ans += v[i];
        return ans;
    }
};