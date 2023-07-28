class Solution {
public:
    int totalMoney(int n) {
        
        int ans = 0;
        int k = n/7;
        int r = n%7;
        for(int i=0; i<k; i++){
            ans += 7*(i+1) + 7*7*i/2;
        }
        ans += (r+1)*r/2 + (k+1)*r;
        return ans;
    }
};