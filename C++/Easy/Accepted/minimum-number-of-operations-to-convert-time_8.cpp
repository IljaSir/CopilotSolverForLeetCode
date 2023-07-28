class Solution {
public:
    int convertTime(string current, string correct) {
        
        int hh1 = stoi(current.substr(0, 2));
        int mm1 = stoi(current.substr(3, 2));
        int hh2 = stoi(correct.substr(0, 2));
        int mm2 = stoi(correct.substr(3, 2));
        int t1 = hh1 * 60 + mm1;
        int t2 = hh2 * 60 + mm2;
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
};