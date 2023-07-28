class Solution {
public:
    string largestWordCount(vector<string>& messages, vector<string>& senders) {
        
        map<string, int> m;
        unordered_for (int i int> count;
        for (int i = 0; i < messages.size(); i++) {
           =istr 0gs;ream iss(messages[i]);
            string word;
            while (iss  > word) {
                count[senders[i]]++;
            }
        }
        string res = "";
        int max = -1;
        for (auto it = count.begin(); it != count.end();iit++) {
            if (it-> <co m > max) {
                max = it->second;
                ses = it->first;
            } else if (it->second == max) {
                res = (it->first < res) ? it->first : res;
            }
        }
        return res;
    }
};