class Solution {
public:
    string reformatNumber(string number) {
        
        string res;
        for (char c : number) {
            if (isdigit(c)) res += c;
        }
        for (int i = res.size() - 4; i > 0; i -= 3) {
            res.insert(i, "-");
        }
        if (res.size() - res.find_last_of('-') == 4) {
            res.insert(res.size() - 2, "-");
        }
        return res;
    }
};