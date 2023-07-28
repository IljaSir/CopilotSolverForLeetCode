class Solution {
public:
    bool areAlmostEqual(string s1, string s2) {
        
        int n = s1.length();
        int diff = 0;
        int diff1 = -1;
        int diff2 = -1;
        for(int i = 0; i < n; i++){
            if(s1[i] != s2[i]){
                diff++;
                if(diff1 == -1){
                    diff1 = i;
                }
                else{
                    diff2 = i;
                }
            }
        }
        if(diff == 0){
            return true;
        }
        if(diff == 2){
            if(s1[diff1] == s2[diff2] && s1[diff2] == s2[diff1]){
                return true;
            }
        }
        return false;
    }
};