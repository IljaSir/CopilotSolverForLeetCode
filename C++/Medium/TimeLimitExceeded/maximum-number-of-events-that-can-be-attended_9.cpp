class Solution {
public:
    int maxEvents(vector<vector<int>>& events) {
        
        sort(events.begin(), events.end(), [](auto &a, auto &b){return a[1] < b[1];});
        int ans = 0;
        unordered_set<int> days;
        for (auto &e : events) {
            for (int i = e[0]; i <= e[1]; ++i) {
                if (days.find(i) == days.end()) {
                    days.insert(i);
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
};