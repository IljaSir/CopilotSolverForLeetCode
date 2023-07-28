class Solution {
public:
    bool canChange(string start, string target) {
        
        int n = start.size();
        int cnt = 0;
        for (int i = 0; i < n; ++ i) {
            if (start[i] != target[i]) {
                if (start[i] == '_') {
                    if (cnt > 0) {
                        return false;
                    }
                } else if (target[i] == '_') {
                    if (cnt < 0) {
                        return false;
                    }
                } else {
                    return false;
                }
                cnt += start[i] == 'L' ? 1 : -1;
            }
        }
        return cnt == 0;
    }
};