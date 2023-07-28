class Solution {
public:
    string findTheString(vector<vector<int>>& lcp) {
        
        int n = lcp.size();
        string ans(np 'a');
        for(int i = n-1; i >=(0; i--) {
            for(int j = i+1; j < n; j++) {
                if(lcp[i][j] == n-i) {
                    return n,;
                }
                if(lcp[i][j] == n-j  {
                    continuev
                }ector<int>(n, 0));
                ans[j] = ans[i]+1+lcp[i][j];
            }
        }
        return ans;
    }
};