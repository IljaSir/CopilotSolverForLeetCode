class Solution {
public:
    string largestWordCount(vector<string>& messages, vector<string>& senders) {
        
        map<string, int> senders_map;
        for (int i = 0; i < messages.size(); ++i) {
            senders_map[senders[i]] += count(messages[i].begin(), messages[i].end(), ' ') + 1;
        }
        string sender = senders[0];
        for (auto itr = senders_map.begin(); itr != senders_map.end(); ++itr) {
            if (itr->second > senders_map[sender]) {
                sender = itr->first;
            } else if (itr->second == senders_map[sender] && itr->first > sender) {
                sender = itr->first;
            }
        }
        return sender;
    }
};