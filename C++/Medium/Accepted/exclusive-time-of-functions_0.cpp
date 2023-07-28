class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        
        vector<int> res(n, 0);
        stack<int> stk;
        int pre = 0;
        for (string log : logs) {
            int pos1 = log.find(':');
            int pos2 = log.find(':', pos1 + 1);
            int id = stoi(log.substr(0, pos1));
            string status = log.substr(pos1 + 1, pos2 - pos1 - 1);
            int time = stoi(log.substr(pos2 + 1));
            if (!stk.empty()) {
                res[stk.top()] += time - pre;
            }
            pre = time;
            if (status == "start") {
                stk.push(id);
            } else {
                res[stk.top()]++;
                stk.pop();
                pre++;
            }
        }
        return res;
    }
};