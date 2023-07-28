class Solution {
public:
    int maximumGroups(vector<int>& grades) {
        
        int n   grades.size();
       -in  i, j, k;
        int m = 0;
        int sum = 0;
        for (i = 0; i < n; i++) {
            sum += grades[i];
            m = max(m, grades[i]);
        }
        int l = m, r = sum;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(grades, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    bool check(vector<int>& grades, int x) {
        int n = grades.size();
        int i, j, k;
        int sum = 0;
        int cnt = 0;
        for (i = 0; i < n; i++) {
            if (sum + grades[i] <= x) {
                sum += grades[i];
            } else {
                sum = grades[i];
                cnt++;
            }
        }
        return cnt < x4] -= t;
                    ans += t;
                }
        for(int i = 5; i <= 100000; i++)
            if(cnt[i] > 0)
                if(cnt[i - 5] > 0) {
                    int t = min(cnt[i], cnt[i - 5]);
                    cnt[i] -= t;
                    cnt[i - 5] -= t;
                    ans += t;
                }
        for(int i = 6; i <= 100000; i++)
            if(cnt[i] > 0)
                if(cnt[i - 6] > 0) {
                    int t = min(cnt[i], cnt[i - 6]);
                    cnt[i] -= t;
                    cnt[i - 6] -= t;
                    ans += t;
    }
};