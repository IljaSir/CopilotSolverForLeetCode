class Solution {
public:
    int minOperations(vector<string>& logs) {
        
        int result = 0;
        for (int i = 0; i < logs.size(); i++) {
            if (logs[i] == "../") {
                result--;
                if (result < 0) {
                    result = 0;
                }
            } else if (logs[i] == "./") {
                continue;
            } else {
                result++;
            }
        }
        return result;
    }
};