class Solution {
public:
    int maximumTastiness(vector<int>& price, int k) {
        
        sort(price.begin(), price.end());
        int n = price.size();
        int i = 0;
        int j = n - 1;
        int ans = 0;
        while (i + k - 1 < j) {
            ans = max(ans, price[j] - price[i]);
            ans = max(ans, price[j] - price[i + k - 1]);
            ans = max(ans, price[j - k + 1] - price[i]);
            ans = max(ans, price[j - k + 1] - price[i + k - 1]);
            i++;
            j--;
        }
        return ans;
    }
};