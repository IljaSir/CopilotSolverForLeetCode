class Solution {
public:
    bool haveConflict(vector<string>& event1, vector<string>& event2) {
        
        int t1 = stoi(event1[0].substr(0,2))*60 + stoi(event1[0].substr(3,2));
        int t2 = stoi(event1[1].substr(0,2))*60 + stoi(event1[1].substr(3,2));
        int t3 = stoi(event2[0].substr(0,2))*60 + stoi(event2[0].substr(3,2));
        int t4 = stoi(event2[1].substr(0,2))*60 + stoi(event2[1].substr(3,2));
        return t1 <= t3 && t3 < t2 || t3 <= t1 && t1 < t4;
    }
};