class Solution {
public:
    string makeLargestSpecial(string s) {
        
        int n = s.size();
        vector<string> v;
        int i = 0;
        int cnt = 0;
        while (i < n) {
            if (s[i] == '1') {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt == 0) {
                v.push_back('1' + makeLargestSpecial(s.substr(i + 1, n - i - 2)) + '0');
                i = n;
            }
            i++;
        }
        sort(v.begin(), v.end());
        reverse(v.begin(), v.end());
        string res = "";
        for (auto s : v) {
            res += s;
        }
        return res;
    }
};