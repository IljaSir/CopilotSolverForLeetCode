class Solution {
public:
    bool canChange(string start, string target) {
        
        int n = start.size();
        int i = 0;
        while (i < n && start[i] == target[i]) {
            i++;
        }
        if (i == n) {
            return true;
        }
        int j = n - 1;
        while (j > i && start[j] == target[j]) {
            j--;
        }
        return start.substr(i, j - i + 1) == target.substr(i, j - i + 1);
    }
    bool canTransform(string start, string target) {
        if (start.size() != target.size()) {
            return false;
        }
        if (start == target) {
            return true;
        }
        if (start.size() == 1) {
            return false;
        }
        if (start[0] == target[0] && start[start.size() - 1] == target[target.size() - 1]) {
            return canChange(start, target);
        }
        return false;
    }
};