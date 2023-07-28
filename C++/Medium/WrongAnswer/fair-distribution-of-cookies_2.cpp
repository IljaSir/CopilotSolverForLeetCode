class Solution {
public:
    int distributeCookies(vector<int>& cookies, int k) {
        
        int n = cookies.size();
        sort(cookies.begin(), cookies.end());
        int ans = INT_MAX;
        for (int i = 0; i < n - k + 1; ++i) {
            ans = min(ans, cookies[i + k - 1] - cookies[i]);
        }
        return ans;
    }
};