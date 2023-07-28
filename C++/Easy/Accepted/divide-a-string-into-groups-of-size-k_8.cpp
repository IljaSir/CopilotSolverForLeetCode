class Solution {
public:
    vector<string> divideString(string s, int k, char fill) {
        
        int n = s.length();
        vector<string> ans;
        int i = 0;
        while (i < n) {
            string t = s.substr(i, k);
            i += k;
            while (t.length() < k) {
                t.push_back(fill);
            }
            ans.push_back(t);
        }
        return ans;
    }
};