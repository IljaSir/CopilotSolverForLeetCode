class Solution {
public:
    int minAddToMakeValid(string s) {
        
        int l = 0, r = 0;
        for(auto c: s){
            if(c == '(') l++;
            else{
                if(l > 0) l--;
                else r++;
            }
        }
        return l + r;
    }
};