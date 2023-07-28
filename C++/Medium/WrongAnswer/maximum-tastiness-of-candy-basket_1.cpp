class Solution {
public:
    int maximumTastiness(vector<int>& price, int k) {
        
        sort(price.begin(), price.end());
        int n = price.size();
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans += price[n - 1 - i];
        }
        int max_ans = ans;
        for (int i = 0; i < k - 1; i++) {
            ans -= price[n - 1 - i];
            ans += price[i];
            max_ans = max(max_ans, ans);
        }
        return max_ans;
    }
};