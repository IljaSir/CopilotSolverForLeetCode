class Solution {
public:
    int maximumGroups(vector<int>& grades) {
        
        int n = grades.size();
        vector<int> cnt(100001);
        for (int i = 0; i < n; ++i) {
            ++cnt[grades[i]];
        }
        int ans = 0;
        int sum = 0;
        int num = 0;
        for (int i = 1; i <= 100000; ++i) {
            if (cnt[i] == 0) continue;
            if (sum + i > num + 1) {
                ++ans;
                sum = i;
                num = 1;
            } else {
                sum += i;
                num += 1;
            }
            --cnt[i];
            if (cnt[i] > 0) {
                --i;
            }
        }
        return ans;
    }
};