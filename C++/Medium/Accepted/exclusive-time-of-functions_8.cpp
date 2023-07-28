class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        
        vector<int> res(n, 0);
        stack<int> s;
        int preTime = 0;
        for (auto log : logs) {
            int id = 0, time = 0;
            string status;
            stringstream ss(log);
            getline(ss, log, ':');
            id = stoi(log);
            getline(ss, log, ':');
            status = log;
            getline(ss, log, ':');
            time = stoi(log);
            if (status == "start") {
                if (!s.empty()) res[s.top()] += time - preTime;
                s.push(id);
                preTime = time;
            } else {
                res[s.top()] += time - preTime + 1;
                s.pop();
                preTime = time + 1;
            }
        }
        return res;
    }
};