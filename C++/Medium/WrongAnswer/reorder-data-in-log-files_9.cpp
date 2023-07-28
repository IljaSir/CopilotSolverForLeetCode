class Solution {
public:
    vector<string> reorderLogFiles(vector<string>& logs) {
        
        vector<string> res;
        vector<string> digits;
        map<string, string> letters;
        for (const auto& log : logs) {
            auto pos = log.find(' ');
            string id = log.substr(0, pos);
            string content = log.substr(pos + 1);
            if (content[0] >= '0' && content[0] <= '9') {
                digits.push_back(log);
            } else {
                letters[content] = id;
            }
        }
        for (const auto& [content, id] : letters) {
            res.push_back(id + " " + content);
        }
        for (const auto& log : digits) {
            res.push_back(log);
        }
        return res;
    }
};