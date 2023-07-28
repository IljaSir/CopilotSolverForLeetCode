class Solution {
public:
    bool canChange(string start, string target) {
        
        int n = start.size();
        int l = 0, r = n - 1;
        while (l < n && start[l] == target[l]) l++;
        while (r >= 0 && start[r] == target[r]) r--;
        if (l > r) return true;
        for (int i = l; i <= r; i++) {
            if (start[i] == target[i]) continue;
            if (start[i] == 'L' || target[i] == 'R') return false;
        }
        return true;
    }
};