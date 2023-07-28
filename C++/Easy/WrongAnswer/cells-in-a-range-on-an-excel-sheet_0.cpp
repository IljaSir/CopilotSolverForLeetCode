class Solution {
public:
    vector<string> cellsInRange(string s) {
        
        int c1 = s[0] - 'A', r1 = s[1] - '0';
        int c2 = s[3] - 'A', r2 = s[4] - '0';
        vector<string> result;
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                result.push_back(string(1, 'A' + j) + to_string(i));
            }
        }
        return result;
    }
};