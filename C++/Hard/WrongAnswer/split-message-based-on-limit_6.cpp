class Solution {
public:
    vector<string> splitMessage(string message, int limit) {
        
        int n = message.size();
        int parts = (n + limit - 1) / limit;
        int partSize = n / parts;
        int extra = n % parts;
        vector<string> result;
        int i = 0;
        for (int p = 1; p <= parts; ++p) {
            int part = partSize + (p <= extra);
            result.push_back(message.substr(i, part) + "<" + to_string(p) + "/" + to_string(parts) + ">");
            i += part;
        }
        return result;
    }
};