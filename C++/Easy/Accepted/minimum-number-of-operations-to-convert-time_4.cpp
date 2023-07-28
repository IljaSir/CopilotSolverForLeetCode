class Solution {
public:
    int convertTime(string current, string correct) {
        
        int h1 = stoi(current.substr(0, 2));
        int m1 = stoi(current.substr(3, 2));
        int h2 = stoi(correct.substr(0, 2));
        int m2 = stoi(correct.substr(3, 2));
        int t1 = h1 * 60 + m1;
        int t2 = h2 * 60 + m2;
        int diff = t2 - t1;
        int ans = 0;
        while (diff > 0) {
            if (diff >= 60) {
                diff -= 60;
                ans++;
            } else if (diff >= 15) {
                diff -= 15;
                ans++;
            } else if (diff >= 5) {
                diff -= 5;
                ans++;
            } else {
                diff -= 1;
                ans++;
            }
        }
        return ans;
    }
};