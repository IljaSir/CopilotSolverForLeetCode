class Solution {
public:
    bool canTransform(string start, string end) {
        
        // R can only move to right
        // L can only move to left
        // X can move to any direction
        int i=0, j=0;
        int n = start.size();
        while(i<n && j<n) {
            while(i<n && start[i] == 'X') i++;
            while(j<n && end[j] == 'X') j++;
            if(i==n && j==n) return true;
            if(i==n || j==n) return false;
            if(start[i] != end[j]) return false;
            if(start[i] == 'R' && i>j) return false;
            if(start[i] == 'L' && i<
        return true;
    }
};