class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        
        vector<int> result(n, 0);
        stack<int> s;
        int prevTime = 0;
        for (auto &log: logs) {
            int pos = log.find(':');
            int id = stoi(log.substr(0, pos));
            int time = stoi(log.substr(pos+2));
            if (log[pos+1] == 's') {
                if (!s.empty()) {
                    result[s.top()] += time - prevTime;
                }
                s.push(id);
                prevTime = time;
            } else {
                result[s.top()] += time - prevTime + 1;
                s.pop();
                prevTime = time + 1;
            }
        }
        return result;
    }
};