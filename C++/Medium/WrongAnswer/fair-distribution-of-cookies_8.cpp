class Solution {
public:
    int distributeCookies(vector<int>& cookies, int k) {
        
        int n = cookies.size();
        int unfairness = INT_MAX;
        sort(cookies.begin(), cookies.end());
        for (int i = 0; i <= n-k; i++) {
            int min = cookies[i];
            int max = cookies[i+k-1];
            int diff = max - min;
            if (diff < unfairness) unfairness = diff;
        }
        return unfairness;
    }
};