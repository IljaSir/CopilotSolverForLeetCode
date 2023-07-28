class Solution {
public:
    vector<int> executeInstructions(int n, vector<int>& startPos, string s) {
        
        vector<int> result;
        int m = s.size();
        for (int i = 0; i < m; ++i) {
            int x = startPos[0], y = startPos[1];
            int count = 0;
            for (int j = i; j < m; ++j) {
                if (s[j] == 'L' && y > 0) {
                    --y;
                    ++count;
                } else if (s[j] == 'R' && y < n - 1) {
                    ++y;
                    ++count;
                } else if (s[j] == 'U' && x > 0) {
                    --x;
                    ++count;
                } else if (s[j] == 'D' && x < n - 1) {
                    ++x;
                    ++count;
                } else {
                    break;
                }
            }
            result.push_back(count);
        }
        return result;
    }
};