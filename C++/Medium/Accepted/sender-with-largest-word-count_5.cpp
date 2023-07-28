class Solution {
public:
    string largestWordCount(vector<string>& messages, vector<string>& senders) {
        
        map<string, int> m;
        for (int i = 0; i < messages.size(); ++i) {
            stringstream ss(messages[i]);
            string word;
            while (ss >> word) {
                m[senders[i]]++;
            }
        }
        int max = 0;
        string name;
        for (auto it = m.begin(); it != m.end(); ++it) {
            if (it->second > max) {
                max = it->second;
                name = it->first;
            }
            else if (it->second == max) {
                if (it->first > name) {
                    name = it->first;
                }
            }
        }
        return name;
    }
};