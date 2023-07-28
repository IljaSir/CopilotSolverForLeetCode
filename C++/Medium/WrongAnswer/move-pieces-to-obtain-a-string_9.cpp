class Solution {
public:
    bool canChange(string start, string target) {
        
        int n = start.length();
        int l = 0, r = n-1;
        while(l<n && start[l] == target[l]) l++;
        while(r>=0 && start[r] == target[r]) r--;
        if(l>r) return true;
        for(int i=l; i<=r; i++) {
            if(start[i] == target[i]) continue;
            if(start[i] != '_') return false;
        }
        return true;
    }
    
    bool canTransform(string start, string target) {
        if(!canChange(start, target)) return false;
        int n = start.length();
        int l = 0, r = n-1;
        while(l<n && start[l] == target[l]) l++;
        while(r>=0 && start[r] == target[r]) r--;
        if(l>r) return true;
        int lcount = 0, rcount = 0;
        for(int i=l; i<=r; i++) {
            if(start[i] == target[i]) continue;
            if(start[i] == 'L') lcount++;
            else rcount++;
        }
        return lcount == rcount;
    }
};