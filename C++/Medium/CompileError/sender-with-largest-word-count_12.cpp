class Solution {
public:
    string largestWordCount(vector<string>& messages, vector<string>& senders) {
        
        unordered_map<string,int> count;
        for (int i = 0; i < messages.size(); i++) {
            istringstream iss(messages[i]);
            string word;
            while (iss >> word) {
                count[senders[i]]++;
            }
        }
        string res = "";
        int max = -1;
        for (auto it = count.begin(); it != count.end(); it++) {
            if (it->second > max) {
                max = it->second;
                res = it->first;
            } else if (it->second == max) {
                res = (it->first < res) ? it->first : res
                maxSender = p.first;
            }
        }
        return maxSender;
    }
};