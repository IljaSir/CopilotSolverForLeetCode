class Solution {
public:
    bool rotateString(string s, string goal) {
        
        if(s.size() != goal.size()) return false;
        if(s.size() == 0) return true;
        int m = s.size();
        int n = goal.size();
        for(int i=0; i<m; i++){
            if(s[i] == goal[0]){
                int j = i;
                int k = 0;
                while(j < m && k < n){
                    if(s[j] != goal[k]) break;
                    j++;
                    k++;
                }
                if(j == m){
                    for(int l=0; l<i; l++){
                        if(s[l] != goal[k]) return false;
                        k++;
                    }
                    return true;
                }
            }
        }
        return false;
    }
};