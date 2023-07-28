class Solution {
public:
    string reformat(string s) {
        
        string str;
        string num;
        for (auto c : s) {
            if (c >= '0' && c <= '9')
                num.push_back(c);
            else
                str.push_back(c);
        }
        if (abs(str.size() - num.size()) > 1)
            return "";
        string ans;
        if (str.size() > num.size()) {
            for (int i = 0; i < num.size(); ++i) {
                ans.push_back(str[i]);
                ans.push_back(num[i]);
            }
            ans.push_back(str.back());
        } else {
            for (int i = 0; i < str.size(); ++i) {
                ans.push_back(num[i]);
                ans.push_back(str[i]);
            }
            if (num.size() > str.size())
                ans.push_back(num.back());
        }
        return ans;
    }
};