class Solution {
public:
    string reformatNumber(string number) {
        
        string result = "";
        string temp = "";
        for (auto c : number) {
            if (c == ' ' || c == '-') {
                continue;
            }
            temp += c;
        }
        for (int i = 0; i < temp.size(); i += 3) {
            if (i + 4 == temp.size()) {
                result += temp.substr(i, 2) + "-" + temp.substr(i + 2, 2);
                break;
            }
            if (i + 3 == temp.size()) {
                result += temp.substr(i, 3);
                break;
            }
            result += temp.substr(i, 3) + "-";
        }
        return result;
    }
};