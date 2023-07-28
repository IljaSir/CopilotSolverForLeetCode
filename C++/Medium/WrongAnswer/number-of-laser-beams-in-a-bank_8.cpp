class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
        
        int m = bank.size();
        int n = bank[0].size();
        int ans = 0;
        for(int i = 0; i < n; i++)
        {
            int flag = 0;
            for(int j = 0; j < m; j++)
            {
                if(bank[j][i] == '1')
                {
                    if(flag == 0)
                    {
                        flag = 1;
                    }
                    else
                    {
                        ans++;
                        flag = 0;
                        break;
                    }
                }
            }
        }
        return ans;
    }
};