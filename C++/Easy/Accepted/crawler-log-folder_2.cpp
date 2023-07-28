class Solution {
public:
    int minOperations(vector<string>& logs) {
        
        int depth = 0;
        for (auto log : logs) {
            if (log == "../") {
                depth = max(depth - 1, 0);
            } else if (log != "./") {
                depth++;
            }
        }
        return depth;
    }
};