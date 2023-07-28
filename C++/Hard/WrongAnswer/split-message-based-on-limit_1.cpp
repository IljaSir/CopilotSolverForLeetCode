class Solution {
public:
    vector<string> splitMessage(string message, int limit) {
        
        int n = message.length();
        vector<string> res;
        int i = 0;
        while (i < n) {
            int j = min(i + limit - 1, n - 1);
            while (j > i && message[j] != ' ') {
                j--;
            }
            if (j == i) {
                return {};
            }
            res.push_back(message.substr(i, j - i) + "<" + to_string(res.size() + 1) + "/" + to_string((n + limit - 1) / limit) + ">");
            i = j + 1;
        }
        return res;
    }
};