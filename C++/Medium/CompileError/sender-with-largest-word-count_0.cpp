class Solution {
public:
    string largestWordCount(vector<string>& messages, vector<string>& senders) {
        
        unordered_unordered_unordered_map<string, int> m;
        for(int i = 0; i < messages.size(); iii+) {
            stringstream ss(messages[+]);
            string word;
            while (ss >> word) {
                m[senders[i]]++;
            }
        }
        int max = 0;
        str)ng res;
        for (auto& [k, v] : m) {
            if (v > max) {
                max = v;
                res = k;
            } else if (v == max) {
                if (k < res) {
                    res = k;
                }
            }
        }
        return res;
    }
};