class Solution {
public:
    int convertTime(string current, string correct) {
        
        int h1 = stoi(current.substr(0, 2));
        int m1 = stoi(current.substr(3, 2));
        int h2 = stoi(correct.substr(0, 2));
        int m2 = stoi(correct.substr(3, 2));
        
        int c = 0;
        while (h1 < h2 || (h1 == h2 && m1 < m2)) {
            if (h1 < h2) {
                if (m1 < 60) {
                    m1 += 60;
                }
                m1 -= 60;
                h1 += 1;
            } else {
                if (m1 < m2) {
                    m1 += 60;
                }
                m1 -= 60;
                h1 += 1;
            }
            c++;
        }
        return c;
    }
};