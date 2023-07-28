class Solution {
public:
    vector<string> cellsInRange(string s) {
        
        char c1 = s[0];
        char c2 = s[3];
        int r1 = s[1] - '0';
        int r2 = s[4] - '0';
        vector<string> result;
        for (int i = r1; i <= r2; i++) {
            for (char j = c1; j <= c2; j++) {
                string temp;
                temp.push_back(j);
                temp.push_back(i + '0');
                result.push_back(temp);
            }
        }
        return result;
    }
};