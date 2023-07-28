class Solution {
public:
    bool haveConflict(vector<string>& event1, vector<string>& event2) {
        
        int start1 = stoi(event1[0].substr(0,2)) * 60 + stoi(event1[0].substr(3,2));
        int end1 = stoi(event1[1].substr(0,2)) * 60 + stoi(event1[1].substr(3,2));
        int start2 = stoi(event2[0].substr(0,2)) * 60 + stoi(event2[0].substr(3,2));
        int end2 = stoi(event2[1].substr(0,2)) * 60 + stoi(event2[1].substr(3,2));
        if (start1 > end1) {
            end1 += 24 * 60;
        }
        if (start2 > end2) {
            end2 += 24 * 60;
        }
        if (start2 <= start1 && start1 <= end2) {
            return true;
        }
        if (start1 <= start2 && start2 <= end1) {
            return true;
        }
        return false;
    }
};