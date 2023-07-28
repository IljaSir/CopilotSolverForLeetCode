class Solution {
public:
    int maxEvents(vector<vector<int>>& events) {
        
        sort(events.begin(), events.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[1] < b[1];
        });
        unordered_set<int> days;
        for (auto& event: events) {
            for (int i = event[0]; i <= event[1]; ++i) {
                if (days.count(i) == 0) {
                    days.insert(i);
                    break;
                }
            }
        }
        return days.size();
    }
};