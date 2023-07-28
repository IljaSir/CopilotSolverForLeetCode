class Solution {
public:
    string makeLargestSpecial(string s) {
        
        int i = 0, cnt = 0;
        vector<string> v;
        for (int j = 0; j < s.length(); ++j) {
            if (s[j] == '1') cnt++;
            else cnt--;
            if (cnt == 0) {
                v.push_back('1' + makeLargestSpecial(s.substr(i + 1, j - i - 1)) + '0');
                i = j + 1;
            }
        }
        sort(v.begin(), v.end());
        reverse(v.begin(), v.end());
        string res = "";
        for (auto& x: v) res += x;
        return res;
    }
};