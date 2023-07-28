class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        
        vector<int> ans(n, 0);
        stack<int> st;
        int prev = 0;
        for (auto& log: logs) {
            int pos = log.find(':');
            int id = stoi(log.substr(0, pos));
            log = log.substr(pos+1);
            pos = log.find(':');
            bool isStart = (log.substr(0, pos) == "start");
            int t = stoi(log.substr(pos+1));
            if (!st.empty()) {
                ans[st.top()] += t - prev;
            }
            prev = t;
            if (isStart) {
                st.push(id);
            } else {
                ans[st.top()]++;
                st.pop();
                prev++;
            }
        }
        return ans;
    }
};