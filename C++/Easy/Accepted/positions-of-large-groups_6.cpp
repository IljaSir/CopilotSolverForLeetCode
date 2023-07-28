class Solution {
public:
    vector<vector<int>> largeGroupPositions(string s) {
        
        vector<vector<int>> res;
        int start = 0;
        int end = 0;
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s[i] == s[i - 1]) {
                count++;
                end++;
            } else {
                if (count >= 3) {
                    res.push_back({start, end});
                }
                start = i;
                end = i;
                count = 1;
            }
        }
        if (count >= 3) {
            res.push_back({start, end});
        }
        return res;
    }
};