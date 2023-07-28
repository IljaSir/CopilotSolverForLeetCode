class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
        
        int m = bank.size();
        int n = bank[0].size();
        int ans = 0;
        for(int j = 0; j < n; j++){
            int first = -1;
            int last = -1;
            for(int i = 0; i < m; i++){
                if(bank[i][j] == '1'){
                    if(first == -1) first = i;
                    last = i;
                }
            }
            if(first != -1 && last != -1 && first != last) ans += (last - first - 1);
        }
        return ans;
    }
};