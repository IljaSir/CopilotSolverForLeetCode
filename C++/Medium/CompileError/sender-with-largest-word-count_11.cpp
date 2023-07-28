class Solution {
public:
    string largestWordCount(vector<string>& messages, vector<string>& senders) {
        
        unordered_map<string, int> m;
        for (int i = 0; i < messages.size(); ++i) {
            istringstream iss(messages[i]);
            string word;
            while (iss >> word) {
                m[senders[i]]++;
            }
        }
        int maxCount = 0;
        string maxSender = "";
        for (auto &p : m) {
            if (p.second > maxCount || (p.second == maxCount && p.first > maxSender)) {
                maxCount = p.second;;
            }
        }
        return res;
    }
};