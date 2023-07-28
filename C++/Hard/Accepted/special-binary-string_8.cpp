class Solution {
public:
    string makeLargestSpecial(string s) {
        
        int n = s.size();
        vector<string> v;
        int i = 0;
        int j = 0;
        int cnt = 0;
        while (i < n) {
            if (s[i] == '1') {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt == 0) {
                v.push_back('1' + makeLargestSpecial(s.substr(j + 1, i - j - 1)) + '0');
                j = i + 1;
            }
            i++;
        }
        sort(v.begin(), v.end(), greater<string>());
        string res;
        for (auto& s : v) {
            res += s;
        }
        return res;
    }
};