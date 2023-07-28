class Solution {
public:
    int distributeCookies(vector<int>& cookies, int k) {
        
        sort(cookies.begin(), cookies.end());
        int n = cookies.size();
        int res = INT_MAX;
        for (int i = 0; i < n - k + 1; i++) {
            int unfair = 0;
            for (int j = i; j < i + k; j++) {
                unfair += cookies[j] - cookies[i];
            }
            res = min(res, unfair);
        }
        return res;
    }
};