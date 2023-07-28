class Solution {
public:
    int maxScore(string s) {
        
        int count = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '1') count++;
        }
        int max = 0;
        int count1 = 0;
        for (int i = 0; i < s.size() - 1; i++) {
            if (s[i] == '0') count1++;
            else count--;
            if (count1 + count > max) max = count1 + count;
        }
        return max;
    }
};