class Solution {
public:
    string orderlyQueue(string s, int k) {
        
        if (k > 1) {
            sort(s.begin(), s.end());
            return s;
        }
        string ans = s;
        for (int i = 0; i < s.size(); i++) {
            string tmp = s.substr(i) + s.substr(0, i);
            if (tmp < ans) {
                ans = tmp;
            }
        }
        return ans;
    }
};