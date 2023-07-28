class Solution {
public:
    bool repeatedSubstringPattern(string s) {
        
        int n = s.length();
        for(int i = 1; i <= n/2; i++){
            if(n % i == 0){
                string sub = s.substr(0, i);
                int j = i;
                for(; j < n; j += i){
                    if(s.substr(j, i) != sub){
                        break;
                    }
                }
                if(j == n){
                    return true;
                }
            }
        }
        return false;
    }
};