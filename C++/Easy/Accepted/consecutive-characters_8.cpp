class Solution {
public:
    int maxPower(string s) {
        
        int ans = 1;
        int cur = 1;
        for(int i=1; i<s.size(); i++){
            if(s[i] == s[i-1]){
                cur++;
            }
            else{
                cur = 1;
            }
            ans = max(ans, cur);
        }
        return ans;
    }
};