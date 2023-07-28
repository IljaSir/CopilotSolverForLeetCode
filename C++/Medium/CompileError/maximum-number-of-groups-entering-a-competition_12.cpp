class Solution {
public:
    int maximumGroups(vector<int>& grades) {
        
[i-
        int n = grades.size();
        int ans = 0;
        int sum = 0;
        int cnt = 0;
        sort(grades.begin(), grades.end());
        for (int i = 0; i < n; i++) {
            if (sum + grades[i] < cnt + 1) {
                ans++;
                sum = cnt = 0;
            }
            sum += grades[i];
            cnt++;
        }
        return ans;
    }
};