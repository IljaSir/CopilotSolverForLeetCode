class Solution {
public:
    int numTimesAllBlue(vector<int>& flips) {
        
        int n = flips.size();
        vector<int> v(n+1,0);
        int ans = 0, sum = 0;
        for(int i=0;i<n;i++){
            v[flips[i]] = 1;
            sum += flips[i];
            int s = 0;
            for(int j=1;j<=flips[i];j++){
                s += j;
            }
            if(sum == s){
                ans++;
            }
        }
        return ans;
    }
};