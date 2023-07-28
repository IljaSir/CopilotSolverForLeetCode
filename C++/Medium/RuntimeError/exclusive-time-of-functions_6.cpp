class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        
        vector<int> ans(n, 0);
        stack<int> s;
        int prev = 0;
        for (auto& log: logs) {
            auto pos = log.find(":");
            int id = stoi(log.substr(0, pos));
            int t = stoi(log.substr(pos+1));
            pos = log.find(":", pos+1);
            bool start = log[pos+1] == 's';
            if (start) {
                if (!s.empty()) {
                    ans[s.top()] += t - prev;
                }
                s.push(id);
                prev = t;
            } else {
                ans[s.top()] += t - prev + 1;
                s.pop();
                prev = t + 1;
            }
        }
        return ans;
    }
};