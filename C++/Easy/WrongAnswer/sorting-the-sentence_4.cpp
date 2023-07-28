class Solution {
public:
    string sortSentence(string s) {
        
        vector<string> v;
        string temp;
        for (auto c : s) {
            if (c == ' ') {
                v.push_back(temp);
                temp = "";
            } else if (c >= '0' && c <= '9') {
                v.push_back(temp);
                temp = "";
            } else {
                temp += c;
            }
        }
        v.push_back(temp);
        temp = "";
        sort(v.begin(), v.end(), [](string& a, string& b) {
            return a.back() < b.back();
        });
        for (auto s : v) {
            temp += s.substr(0, s.length() - 1);
            temp += ' ';
        }
        temp.pop_back();
        return temp;
    }
};