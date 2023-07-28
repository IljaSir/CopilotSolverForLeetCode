class Solution {
public:
    vector<string> splitMessage(string message, int limit) {
        
        vector<string> result;
        int n = message.size();
        int parts = n / limit;
        if (n % limit != 0) parts++;
        int begin = 0;
        int end = 0;
        for (int i = 0; i < parts; i++) {
            end = begin + limit;
            if (end > n) end = n;
            result.push_back(message.substr(begin, end - begin) + "<" + to_string(i + 1) + "/" + to_string(parts) + ">");
            begin = end;
        }
        return result;
    }
};