class Solution {
public:
    bool canChange(string start, string target) {
        
        int n = start.size();
        int i = 0, j = 0;
        while(i < n && j < n) {
            if(start[i] == '_') {
                i++;
                continue;
            }
            if(target[j] == '_') {
                j++;
                continue;
            }
            if(start[i] != target[j]) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
    bool canTransform(string start, string target) {
        if(start == target) {
            return true;
        }
        if(!canChange(start, target)) {
            return false;
        }
        int n = start.size();
        int i = 0, j = 0;
        while(i < n && j < n) {
            while(i < n && start[i] == '_') {
                i++;
            }
            while(j < n && target[j] == '_') {
                j++;
            }
            if(i == n && j == n) {
                return true;
            }
            if((i < n && j == n) || (i == n && j < n)) {
                return false;
            }
            if(start[i] != target[j]) {
                return false;
            }
            if(start[i] == 'R') {
                if(i > j) {
                    return false;
                }
            } else {
                if(i < j) {
                    return false;
                }
            }
            i++;
            j++;
        }
        return true;
    }
};