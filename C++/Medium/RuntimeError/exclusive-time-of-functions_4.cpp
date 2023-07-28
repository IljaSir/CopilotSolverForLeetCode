class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        
        vector<int> result(n, 0);
        stack<int> s;
        int prev = 0;
        for (auto log: logs) {
            int index = log.find(":");
            int id = stoi(log.substr(0, index));
            int time = stoi(log.substr(index + 2));
            if (log.find("start") != string::npos) {
                if (!s.empty()) {
                    result[s.top()] += time - prev;
                }
                s.push(id);
                prev = time;
            } else {
                result[s.top()] += time - prev + 1;
                s.pop();
                prev = time + 1;
            }
        }
        return result;
    }
};