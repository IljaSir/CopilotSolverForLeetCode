class Solution {
public:
    int distributeCookies(vector<int>& cookies, int k) {
        
        int n = cookies.size();
        sort(cookies.begin(), cookies.end());
        int ans = 1e9;
        for (int i = 0; i + k - 1 < n; ++i) {
            ans = min(ans, cookies[i + k - 1] - cookies[i]);
        }
        return ans;
    }
};