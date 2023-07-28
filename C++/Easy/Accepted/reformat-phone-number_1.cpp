class Solution {
public:
    string reformatNumber(string number) {
        
        string s;
        for (auto c : number) {
            if (isdigit(c)) {
                s.push_back(c);
            }
        }
        string result;
        while (s.size() > 4) {
            result += s.substr(0, 3) + "-";
            s.erase(0, 3);
        }
        if (s.size() == 4) {
            result += s.substr(0, 2) + "-" + s.substr(2, 2);
        } else {
            result += s;
        }
        return result;
    }
};