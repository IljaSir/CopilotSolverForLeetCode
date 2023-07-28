class Solution {
public:
    vector<string> splitMessage(string message, int limit) {
        
        int n = message.size();
        vector<string> result;
        if (n <= limit) {
            result.push_back(message + "<1/1>");
            return result;
        }
        int i = 0;
        int j = 0;
        while (i < n) {
            j = i + limit - 1;
            while (j < n && message[j] != ' ') {
                j++;
            }
            if (j >= n) {
                j = n - 1;
            }
            int len = j - i + 1;
            int n_parts = ceil((double)n / limit);
            string part = message.substr(i, len) + "<" + to_string(i / limit + 1) + "/" + to_string(n_parts) + ">";
            result.push_back(part);
            i = j + 1;
        }
        return result;
    }
};