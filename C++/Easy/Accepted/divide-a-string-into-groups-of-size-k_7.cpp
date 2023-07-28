class Solution {
public:
    vector<string> divideString(string s, int k, char fill) {
        
        vector<string> result;
        int n = s.size();
        int i = 0;
        while (i < n) {
            string group;
            for (int j = 0; j < k; j++) {
                if (i < n) {
                    group.push_back(s[i++]);
                } else {
                    group.push_back(fill);
                }
            }
            result.push_back(group);
        }
        return result;
    }
};