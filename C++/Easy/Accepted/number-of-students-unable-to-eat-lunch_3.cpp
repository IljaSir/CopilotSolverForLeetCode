class Solution {
public:
    int countStudents(vector<int>& students, vector<int>& sandwiches) {
        
        int n = students.size();
        int m = sandwiches.size();
        vector<int> cnt(2, 0);
        for (int i = 0; i < n; i++) {
            cnt[students[i]]++;
        }
        int i = 0;
        while (i < m && cnt[sandwiches[i]]) {
            cnt[sandwiches[i]]--;
            i++;
        }
        return m - i;
    }
};