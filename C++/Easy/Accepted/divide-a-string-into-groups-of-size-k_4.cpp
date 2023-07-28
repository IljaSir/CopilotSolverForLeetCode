class Solution {
public:
    vector<string> divideString(string s, int k, char fill) {
        
        vector<string> res;
        int i = 0;
        while (i < s.size()) {
            string temp;
            for (int j = 0; j < k; j++) {
                if (i < s.size()) {
                    temp.push_back(s[i++]);
                } else {
                    temp.push_back(fill);
                }
            }
            res.push_back(temp);
        }
        return res;
    }
};