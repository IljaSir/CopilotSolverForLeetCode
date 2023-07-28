class Solution {
public:
    int numDifferentIntegers(string word) {
        
        unordered_set<string> s;
        string cur;
        for (char c: word) {
            if (!isdigit(c)) {
                if (cur.size() > 0) {
                    s.insert(cur);
                    cur.clear();
                }
            } else {
                if (cur.size() == 0 || cur[0] != '0') {
                    cur += c;
                }
            }
        }
        if (cur.size() > 0) {
            s.insert(cur);
        }
        return s.size();
    }
};