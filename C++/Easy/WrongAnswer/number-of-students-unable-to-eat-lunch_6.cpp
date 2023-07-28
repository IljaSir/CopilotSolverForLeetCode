class Solution {
public:
    int countStudents(vector<int>& students, vector<int>& sandwiches) {
        
        int n = students.size();
        int m = sandwiches.size();
        int i = 0;
        int j = 0;
        while (i < n) {
            if (students[i] == sandwiches[j]) {
                i = 0;
                j++;
            } else {
                i++;
            }
            if (j >= m) {
                break;
            }
        }
        return n - i;
    }
};