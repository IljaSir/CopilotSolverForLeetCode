class Solution {
public:
    int numTimesAllBlue(vector<int>& flips) {
        
        int n = flips.size();
        vector<int> v(n, 0);
        int ans = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            v[flips[i] - 1] = 1;
            sum++;
            while(sum == n || (sum < n && v[sum] == 1)){
                sum++;
            }
            if(sum == n){
                ans++;
            }
        }
        return ans;
    }
};