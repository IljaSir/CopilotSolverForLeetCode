class Solution {
public:
    string reformatNumber(string number) {
        
        string result;
        for (auto c : number) {
            if (c >= '0' && c <= '9') {
                result.push_back(c);
            }
        }
        int n = result.size();
        string out;
        for (int i = 0; i < n; i += 3) {
            if (i + 3 < n) {
                out += result.substr(i, 3) + '-';
            } else if (i + 3 == n) {
                out += result.substr(i, 2) + '-' + result.substr(i + 2, 1);
            } else if (i + 2 == n) {
                out += result.substr(i, 2);
            } else if (i + 1 == n) {
                out += result.substr(i, 1);
            }
        }
        return out;
    }
};