class Solution {
public:
    int maximumGroups(vector<int>& grades) {
        
        int n = grades.size();
        int i, j, k;
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
        return cnt < x;
    }
};