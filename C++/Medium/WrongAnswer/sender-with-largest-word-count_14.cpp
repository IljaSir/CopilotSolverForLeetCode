class Solution {
public:
    string largestWordCount(vector<string>& messages, vector<string>& senders) {
        
        unordered_map<string, int> m;
        for (int i = 0; i < messages.size(); i++) {
            int count = 1;
            for (auto c : messages[i]) {
                if (c == ' ') {
                    count++;
                }
            }
            m[senders[i]] += count;
        }
        int maxCount = -1;
        string res;
        for (auto it = m.begin(); it != m.end(); it++) {
            if (it->second > maxCount) {
                maxCount = it->second;
                res = it->first;
            } else if (it->second == maxCount) {
                res = res < it->first ? res : it->first;
            }
        }
        return res;
    }
};