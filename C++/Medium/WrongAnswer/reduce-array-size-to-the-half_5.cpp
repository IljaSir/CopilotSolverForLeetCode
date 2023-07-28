class Solution {
public:
    int minSetSize(vector<int>& arr) {
        
        int n = arr.size();
        vector<int> cnt(n + 1);
        for (int i = 0; i < n; ++i) {
            cnt[arr[i]]++;
        }
        sort(cnt.begin(), cnt.end(), greater<int>());
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans++;
            n -= cnt[i];
            if (n <= n / 2) {
                break;
            }
        }
        return ans;
    }
};