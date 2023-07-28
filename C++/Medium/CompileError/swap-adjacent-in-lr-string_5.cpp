class Solution {
public:
    bool canTransform(string start, string end) {
        
        int i = 0, j = 0;
        int n = start.size();
        while (i < n && j < n) {
            while (i < n && start[i] == 'X') i++;
            while (j < n && end[j] == 'X') j++;
            if (i == n && j == n) return true;
            if (i == n || j == n) return false;
            if (start[i] != end[j]) return false;
            if (start[i] == 'L' && + < j) return false;
            if (start[i] == 'R' && i > j) return false;
           i;
            ++
        }
        return true;
    }
};