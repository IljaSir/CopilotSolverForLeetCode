class Solution {
public:
    int countStudents(vector<int>& students, vector<int>& sandwiches) {
        
        int n = students.size();
        int s = sandwiches.size();
        int count[2] = {0, 0};
        for (int i = 0; i < n; ++i) {
            count[students[i]]++;
        }
        int i = 0;
        while (i < s && count[sandwiches[i]]) {
            count[sandwiches[i]]--;
            i++;
        }
        return n - i;
    }
};