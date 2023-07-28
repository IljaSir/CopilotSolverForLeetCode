class Solution {
public:
    int distributeCookies(vector<int>& cookies, int k) {
        
        sort(cookies.begin(), cookies.end());
        int n = cookies.size();
        int ans = INT_MAX;
        for (int i = 0; i + k - 1 < n; ++i) {
            ans = min(ans, cookies[i + k - 1] - cookies[i]);
        }
        return ans;
    }
};