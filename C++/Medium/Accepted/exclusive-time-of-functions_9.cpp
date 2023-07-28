class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        
        vector<int> result(n, 0);
        stack<int> stk;
        int prevTime = 0;
        for (string& log : logs) {
            int id = 0, time = 0;
            string state;
            stringstream ss(log);
            getline(ss, log, ':');
            id = stoi(log);
            getline(ss, log, ':');
            state = log;
            getline(ss, log, ':');
            time = stoi(log);
            if (state == "start") {
                if (!stk.empty()) {
                    result[stk.top()] += time - prevTime;
                }
                stk.push(id);
                prevTime = time;
            } else {
                result[stk.top()] += time - prevTime + 1;
                stk.pop();
                prevTime = time + 1;
            }
        }
        return result;
    }
};