class Solution {
public:
    int countDaysTogether(string arriveAlice, string leaveAlice, string arriveBob, string leaveBob) {
        
        int ans = 0;
        int m1 = stoi(arriveAlice.substr(0, 2));
        int d1 = stoi(arriveAlice.substr(3, 2));
        int m2 = stoi(leaveAlice.substr(0, 2));
        int d2 = stoi(leaveAlice.substr(3, 2));
        int m3 = stoi(arriveBob.substr(0, 2));
        int d3 = stoi(arriveBob.substr(3, 2));
        int m4 = stoi(leaveBob.substr(0, 2));
        int d4 = stoi(leaveBob.substr(3, 2));
        int days[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int d1_ = 0, d2_ = 0, d3_ = 0, d4_ = 0;
        for (int i = 0; i < m1 - 1; ++i) d1_ += days[i];
        for (int i = 0; i < m2 - 1; ++i) d2_ += days[i];
        for (int i = 0; i < m3 - 1; ++i) d3_ += days[i];
        for (int i = 0; i < m4 - 1; ++i) d4_ += days[i];
        d1_ += d1;
        d2_ += d2;
        d3_ += d3;
        d4_ += d4;
        for (int i = d1_; i <= d2_; ++i) {
            for (int j = d3_; j <= d4_; ++j) {
                if (i == j) ans++;
            }
        }
        return ans;
    }
};