class Solution {
public:
    bool canBeValid(string s, string locked) {
        
        int n = s.size();
        int count = 0;
        int open = 0;
        bool flag = true;
        for (int i = 0; i < n; i++) {
            if (locked[i] == '1') {
                if (s[i] == '(') {
                    count++;
                } else {
                    count--;
                }
            } else {
                if (s[i] == '(') {
                    open++;
                } else {
                    if (open > 0) {
                        open--;
                    } else {
                        flag = false;
                    }
                }
            }
        }
        return count == 0 && flag;
    }
};