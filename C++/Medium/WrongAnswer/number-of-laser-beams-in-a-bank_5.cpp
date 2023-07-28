class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
        
        int m = bank.size();
        int n = bank[0].size();
        int ans = 0;
        for(int i=0; i<n; i++){
            int cnt = 0;
            for(int j=0; j<m; j++){
                if(bank[j][i] == '1'){
                    cnt++;
                    if(cnt > 1) break;
                }
            }
            ans += cnt;
        }
        return ans;
    }
};