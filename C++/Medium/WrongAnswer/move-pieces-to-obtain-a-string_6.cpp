class Solution {
public:
    bool canChange(string start, string target) {
        
        int n = start.size();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (start[i] != target[i]) cnt++;
        }
        return cnt <= 2;
    }
    bool canTransform(string start, string target) {
        if (!canChange(start, target)) return false;
        int n = start.size();
        int cntl = 0, cntr = 0, cntt = 0;
        for (int i = 0; i < n; i++) {
            if (start[i] == 'L') cntl++;
            if (start[i] == 'R') cntr++;
            if (target[i] == 'L') cntl--;
            if (target[i] == 'R') cntr--;
            if (cntl < 0 || cntr > 0) return false;
        }
        return true;
    }
};