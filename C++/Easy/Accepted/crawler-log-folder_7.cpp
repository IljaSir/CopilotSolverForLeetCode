class Solution {
public:
    int minOperations(vector<string>& logs) {
        
        int count = 0;
        for (const auto& log : logs) {
            if (log == "../") {
                count = max(count - 1, 0);
            } else if (log != "./") {
                ++count;
            }
        }
        return count;
    }
};