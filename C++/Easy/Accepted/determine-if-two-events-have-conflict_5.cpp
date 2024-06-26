class Solution {
public:
    bool haveConflict(vector<string>& event1, vector<string>& event2) {
        
        int h1 = stoi(event1[0].substr(0, 2));
        int m1 = stoi(event1[0].substr(3, 2));
        int h2 = stoi(event1[1].substr(0, 2));
        int m2 = stoi(event1[1].substr(3, 2));
        int h3 = stoi(event2[0].substr(0, 2));
        int m3 = stoi(event2[0].substr(3, 2));
        int h4 = stoi(event2[1].substr(0, 2));
        int m4 = stoi(event2[1].substr(3, 2));
        int t1 = h1 * 60 + m1;
        int t2 = h2 * 60 + m2;
        int t3 = h3 * 60 + m3;
        int t4 = h4 * 60 + m4;
        return t1 <= t4 && t3 <= t2;
    }
};