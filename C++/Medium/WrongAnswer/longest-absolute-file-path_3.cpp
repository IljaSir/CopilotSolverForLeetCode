class Solution {
public:
    int lengthLongestPath(string input) {
        
        int res = 0;
        int level = 0;
        int len = 0;
        int n = input.size();
        unordered_map<int, int> m;
        for (int i = 0; i < n; i++) {
            if (input[i] == '\n') {
                len = 0;
                level = 0;
            } else if (input[i] == '\t') {
                level++;
            } else if (input[i] == '.') {
                res = max(res, m[level] + len + 1);
            } else {
                len++;
                m[level + 1] = m[level] + len + 1;
            }
        }
        return res;
    }
};