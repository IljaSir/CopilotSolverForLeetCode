class Solution {
public:
    int convertTime(string current, string correct) {
        
        int h1, m1, h2, m2;
        sscanf(current.c_str(), "%d:%d", &h1, &m1);
        sscanf(correct.c_str(), "%d:%d", &h2, &m2);
        int t1 = h1 * 60 + m1;
        int t2 = h2 * 60 + m2;
        int t = t2 - t1;
        int ans = 0;
        while (t > 0) {
            if (t >= 60) {
                t -= 60;
                ans++;
            } else if (t >= 15) {
                t -= 15;
                ans++;
            } else if (t >= 5) {
                t -= 5;
                ans++;
            } else {
                t--;
                ans++;
            }
        }
        return ans;
    }
    int numberOfRounds(string startTime, string finishTime) {
        int h1, m1, h2, m2;
        sscanf(startTime.c_str(), "%d:%d", &h1, &m1);
        sscanf(finishTime.c_str(), "%d:%d", &h2, &m2);
        int t1 = h1 * 60 + m1;
        int t2 = h2 * 60 + m2;
        if (t1 > t2) {
            t2 += 24 * 60;
        }
        int ans = 0;
        while (t1 < t2) {
            if (t1 % 15 == 0) {
                ans++;
            }
            t1 += 1;
        }
        return ans;
    }
    int numberOfRounds(string startTime, string finishTime) {
        int h1, m1, h2, m2;
        sscanf(startTime.c_str(), "%d:%d", &h1, &m1);
        sscanf(finishTime.c_str(), "%d:%d", &h2, &m2);
        int t1 = h1 * 60 + m1;
        int t2 = h2 * 60 + m2;
        if (t1 > t2) {
            t2 += 24 * 60;
        }
        int ans = 0;
        while (t1 < t2) {
            if (t1 % 15 == 0) {
    }
};