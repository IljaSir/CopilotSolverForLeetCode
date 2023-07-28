class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        
        vector<int> res(n);
        stack<int> st;
        int last = 0;
        for (string &log: logs) {
            int pos = log.find(':');
            int id = stoi(log.substr(0, pos));
            int pos2 = log.find(':', pos + 1);
            string status = log.substr(pos + 1, pos2 - pos - 1);
            int time = stoi(log.substr(pos2 + 1));
            if (!st.empty()) {
                res[st.top()] += time - last;
            }
            last = time;
            if (status == "start") {
                st.push(id);
            } else {
                res[st.top()]++;
                last++;
                st.pop();
            }
        }
        return res;
    }
};