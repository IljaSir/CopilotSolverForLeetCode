class Solution {
public:
    vector<string> splitMessage(string message, int limit) {
        
        int n = message.size();
        int parts = (n + limit - 1) / limit;
        vector<string> result;
        for (int i = 0; i < parts; ++i) {
            int len = min(limit, n - i * limit);
            result.push_back(message.substr(i * limit, len));
            result.back() += "<" + to_string(i + 1) + "/" + to_string(parts) + ">";
        }
        return result;
    }
};