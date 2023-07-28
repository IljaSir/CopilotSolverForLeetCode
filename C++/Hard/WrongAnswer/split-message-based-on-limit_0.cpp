class Solution {
public:
    vector<string> splitMessage(string message, int limit) {
        
        int n = message.size();
        vector<string> res;
        for (int i = 0; i < n; i += limit) {
            int j = min(i + limit, n);
            string s = message.substr(i, j - i);
            s += "<" + to_string(res.size() + 1) + "/" + to_string((n + limit - 1) / limit) + ">";
            res.push_back(s);
        }
        return res;
    }
};