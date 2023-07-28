class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        
        vector<int> res(n, 0);
        stack<int> st;
        int pre = 0;
        for (auto log: logs) {
            int pos1 = log.find(':');
            int pos2 = log.find(':', pos1 + 1);
            int id = stoi(log.substr(0, pos1));
            string status = log.substr(pos1 + 1, pos2 - pos1 - 1);
            int time = stoi(log.substr(pos2 + 1));
            if (status == "start") {
                if (!st.empty()) {
                    res[st.top()] += time - pre;
                }
                st.push(id);
                pre = time;
            } else {
                res[st.top()] += time - pre + 1;
                st.pop();
                pre = time + 1;
            }
        }
        return res;
    }
};