class Solution {
public:
    vector<int> assignTasks(vector<int>& servers, vector<int>& tasks) {
        
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> available;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> busy;
        for (int i = 0; i < servers.size(); ++i) {
            available.push({servers[i], i});
        }
        vector<int> ans;
        int time = 0;
        for (int i = 0; i < tasks.size(); ++i) {
            while (!busy.empty() && busy.top().first <= time) {
                available.push({busy.top().second, busy.top().first});
                busy.pop();
            }
            if (available.empty()) {
                time = busy.top().first;
                while (!busy.empty() && busy.top().first <= time) {
                    available.push({busy.top().second, busy.top().first});
                    busy.pop();
                }
            }
            auto server = available.top();
            available.pop();
            busy.push({time + tasks[i], server.second});
            ans.push_back(server.second);
            time = max(time, i + 1);
        }
        while (!busy.empty()) {
            while (!busy.empty() && busy.top().first <= time) {
                available.push({busy.top().second, busy.top().first});
                busy.pop();
            }
            auto server = available.top();
            available.pop();
            busy.push({time + tasks.back(), server.second});
            ans.push_back(server.second);
            time = busy.top().first;
        }
        return ans;
    }
};