class Solution {
public:
    int distributeCookies(vector<int>& cookies, int k) {
        
        int n = cookies.size();
        sort(cookies.begin(), cookies.end());
        int minUnfairness = INT_MAX;
        for (int i = 0; i < n - k + 1; ++i) {
            int unfairness = cookies[i + k - 1] - cookies[i];
            if (unfairness < minUnfairness) {
                minUnfairness = unfairness;
            }
        }
        return minUnfairness;
    }
};