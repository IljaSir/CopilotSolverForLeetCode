class Solution {
public:
    int minFlipsMonoIncr(string s) {
        
        int n = s.size();
        int zero = 0;
        int one = 0;
        for(int i = 0; i < n; i++){
            if(s[i] == '0'){
                zero++;
            }else{
                one++;
            }
        }
        int ans = min(zero, one);
        int cur = 0;
        for(int i = 0; i < n; i++){
            if(s[i] == '0'){
                cur++;
            }else{
                cur--;
            }
            ans = min(ans, cur);
        }
        return ans;
    }
};