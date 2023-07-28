class Solution {
public:
    int repeatedStringMatch(string a, string b) {
        
        int cnt = 0;
        string tmp = "";
        while (tmp.size() < b.size()) {
            tmp += a;
            cnt++;
        }
        if (tmp.find(b) != string::npos) return cnt;
        tmp += a;
        if (tmp.find(b) != string::npos) return cnt + 1;
        return -1;
    }
};