class Solution {
public:
    int distributeCookies(vector<int>& cookies, int k) {
        
        sort(cookies.begin(), cookies.end());
        int n = cookies.size();
        int res = INT_MAX;
        for (int i = 0; i < n - k + 1; i++) {
            res = min(res, cookies[i + k - 1] - cookies[i]);
        }
        return res;
    }
};