class Solution {
public:
    string largestWordCount(vector<string>& messages, vector<string>& senders) {
        
        map<string, int> wordCount;
        for(int i = 0; i < messages.size(); i++){
            wordCount[senders[i]] += count(messages[i].begin(), messages[i].end(), ' ') + 1;
        }
        int maxCount = 0;
        string maxName = "";
        for(auto& x: wordCount){
            if(x.second > maxCount){
                maxCount = x.second;
                maxName = x.first;
            }
            else if(x.second == maxCount && x.first > maxName){
                maxName = x.first;
            }
        }
        return maxName;
    }
};