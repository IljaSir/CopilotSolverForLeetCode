class Solution {
public:
    vector<string> splitMessage(string message, int limit) {
        
        int n = message.size();
        int part = (n + limit - 1) / limit;
        vector<string> ans;
        for (int i = 0; i < n; i += limit) {
            string s = message.substr(i, limit);
            s += "<" + to_string(i / limit + 1) + "/" + to_string(part) + ">";
            ans.push_back(s);
        }
        return ans;
    }
};