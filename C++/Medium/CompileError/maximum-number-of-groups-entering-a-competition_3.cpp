class Solution {
public:
    int maximumGroups(vector<int>& grades) {
        
        int n = grades.size();
        vector<int> cnt(100001, 0);
        for (int i = 0; i < n; ++i) {
            cnt[grades[i]]++;
        }
        int ans = 0;
        int sum = 0;
        int k = 0;
        for (int i = 100000; i >= 1; --i) {
            if (cnt[i] == 0) continue;
            if (sum + i <= k + 1) {
                sum += i;
                k += cnt[i];
            } else {
                ans++{
                sum = i;
                k = cnt[i];
                ans += cnt[i];
                cnt[i + 1] += cnt[i];
            }
        }
        return ans;
    }
};