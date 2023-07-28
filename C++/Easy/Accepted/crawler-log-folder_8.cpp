class Solution {
public:
    int minOperations(vector<string>& logs) {
        
        int res = 0;
        for (auto &s : logs) {
            if (s == "../") {
                if (res > 0) res--;
            } else if (s == "./") {
                continue;
            } else {
                res++;
            }
        }
        return res;
    }
};