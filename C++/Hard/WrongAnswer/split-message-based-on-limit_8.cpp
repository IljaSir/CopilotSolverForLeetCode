class Solution {
public:
    vector<string> splitMessage(string message, int limit) {
        
        int n = message.size();
        int i = 0;
        int p = 0;
        vector<string> res;
        while (i < n) {
            int j = i;
            int k = p;
            int l = 0;
            while (j < n && l < limit) {
                if (message[j] == ' ') {
                    k = j;
                }
                ++j;
                ++l;
            }
            if (j < n && k == p) {
                return {};
            }
            if (j < n) {
                res.push_back(message.substr(i, k - i) + "<" + to_string(++p) + "/" + to_string(n / limit + 1) + ">");
                i = k + 1;
            } else {
                res.push_back(message.substr(i) + "<" + to_string(++p) + "/" + to_string(n / limit + 1) + ">");
                i = j;
            }
        }
        return res;
    }
};