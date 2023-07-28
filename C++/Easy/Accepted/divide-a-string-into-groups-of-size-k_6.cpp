class Solution {
public:
    vector<string> divideString(string s, int k, char fill) {
        
        vector<string> result;
        int i = 0;
        while (i < s.length()) {
            string group = s.substr(i, k);
            if (group.length() < k) {
                group.append(k - group.length(), fill);
            }
            result.push_back(group);
            i += k;
        }
        return result;
    }
};