class Solution {
public:
    int countStudents(vector<int>& students, vector<int>& sandwiches) {
        
        int a = 0, b = 0;
        for (int i = 0; i < students.size(); i++) {
            if (students[i] == 0) a++;
            else b++;
        }
        for (int i = 0; i < sandwiches.size(); i++) {
            if (sandwiches[i] == 0) {
                if (a == 0) return b;
                a--;
            } else {
                if (b == 0) return a;
                b--;
            }
        }
        return 0;
    }
};