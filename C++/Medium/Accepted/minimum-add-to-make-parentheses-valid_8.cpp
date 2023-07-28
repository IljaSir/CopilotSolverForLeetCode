class Solution {
public:
    int minAddToMakeValid(string s) {
        
        int count = 0;
        int left = 0;
        for (auto ch : s) {
            if (ch == '(') {
                left++;
            } else {
                if (left > 0) {
                    left--;
                } else {
                    count++;
                }
            }
        }
        return count + left;
    }
};