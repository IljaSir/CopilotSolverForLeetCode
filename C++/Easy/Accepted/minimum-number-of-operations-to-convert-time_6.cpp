class Solution {
public:
    int convertTime(string current, string correct) {
        
        int h1 = (current[0] - '0') * 10 + current[1] - '0';
        int m1 = (current[3] - '0') * 10 + current[4] - '0';
        int h2 = (correct[0] - '0') * 10 + correct[1] - '0';
        int m2 = (correct[3] - '0') * 10 + correct[4] - '0';
        int t1 = h1 * 60 + m1;
        int t2 = h2 * 60 + m2;
        int ans = 0;
        while (t1 != t2) {
            if (t1 > t2) t2 += 24 * 60;
            if (t2 - t1 >= 60) {
                t1 += 60;
            } else if (t2 - t1 >= 15) {
                t1 += 15;
            } else if (t2 - t1 >= 5) {
                t1 += 5;
            } else {
                t1 += 1;
            }
            ans++;
        }
        return ans;
    }
};