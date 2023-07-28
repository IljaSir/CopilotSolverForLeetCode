class Solution {
public:
    int convertTime(string current, string correct) {
        
        int h1 = stoi(current.substr(0, 2));
        int m1 = stoi(current.substr(3, 2));
        int h2 = stoi(correct.substr(0, 2));
        int m2 = stoi(correct.substr(3, 2));
        int t1 = h1 * 60 + m1;
        int t2 = h2 * 60 + m2;
        int res = 0;
        while (t1 < t2) {
            if (t2 - t1 >= 60) {
                t1 += 60;
            } else if (t2 - t1 >= 15) {
                t1 += 15;
            } else if (t2 - t1 >= 5) {
                t1 += 5;
            } else {
                t1 += 1;
            }
            res++;
        }
        return res;
    }
    int convertTime1(string current, string correct) {
        int h1 = stoi(current.substr(0, 2));
        int m1 = stoi(current.substr(3, 2));
        int h2 = stoi(correct.substr(0, 2));
        int m2 = stoi(correct.substr(3, 2));
        int t1 = h1 * 60 + m1;
        int t2 = h2 * 60 + m2;
        int res = 0;
        while (t1 < t2) {
            if (t2 - t1 >= 60) {
                t1 += 60;
            } else if (t2 - t1 >= 30) {
                t1 += 30;
            } else if (t2 - t1 >= 15) {
                t1 += 15;
            } else if (t2 - t1 >= 5) {
                t1 += 5;
            } else {
                t1 += 1;
            }
            res++;
        }
        return res;
    }
};