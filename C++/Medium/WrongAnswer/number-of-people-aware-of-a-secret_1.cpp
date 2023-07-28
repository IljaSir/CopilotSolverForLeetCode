class Solution {
public:
    int peopleAwareOfSecret(int n, int delay, int forget) {
        
        int mod = 1e9 + 7;
        int ans = 0;
        for(int i = 1; i <= n; i++){
            if(i <= delay){
                ans++;
            }else{
                ans = (ans * 2) % mod;
                if(i >= forget){
                    ans -= 2;
                }
            }
        }
        return ans;
    }
};