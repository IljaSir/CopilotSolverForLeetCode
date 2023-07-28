class Solution {
public:
    string largestWordCount(vector<string>& messages, vector<string>& senders) {
        
        unordered_map<string, int> sender;
        for (int i = 0; i < messages.size(); i++) {
            istringstream iss(messages[i]);
            string word;
            while (iss >> word) {
                sender[senders[i]]++;
            }
        }
        string res;
        int max = 0;
        for (auto it = sender.begin(); it != sender.end(); it++) {
            if (it->second > max) {
                max = it->second;
                res = it->first;
            } else if (it->second == max) {
                if (it->first > res) {
                    res = it->first;
                }
            }
        }
        return res;
    }
};