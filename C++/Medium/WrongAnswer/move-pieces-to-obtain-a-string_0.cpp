class Solution {
public:
    bool canChange(string start, string target) {
        
        int n = start.size();
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n && start[i] == '_') i++;
            while (j < n && target[j] == '_') j++;
            if (i == n || j == n) break;
            if (start[i] != target[j]) return false;
            i++; j++;
        }
        return true;
    }
    bool canTransform(string start, string target) {
        if (!canChange(start, target)) return false;
        int n = start.size();
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n && start[i] == '_') i++;
            while (j < n && target[j] == '_') j++;
            if (i == n || j == n) break;
            if (start[i] != target[j]) return false;
            if (start[i] == 'L') {
                if (j > i) return false;
            } else {
                if (j < i) return false;
            }
            i++; j++;
        }
        return true;
    }
};