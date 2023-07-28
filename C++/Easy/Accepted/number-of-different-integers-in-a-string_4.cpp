class Solution {
public:
    int numDifferentIntegers(string word) {
        
        unordered_set<string> set;
        string tmp;
        for (auto c : word) {
            if (c >= '0' && c <= '9') {
                tmp += c;
            } else {
                if (!tmp.empty()) {
                    while (tmp[0] == '0') {
                        tmp.erase(0, 1);
                    }
                    set.insert(tmp);
                }
                tmp.clear();
            }
        }
        if (!tmp.empty()) {
            while (tmp[0] == '0') {
                tmp.erase(0, 1);
            }
            set.insert(tmp);
        }
        return set.size();
    }
};