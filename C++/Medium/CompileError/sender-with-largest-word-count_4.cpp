class Solution {
public:
    string largestWordCount(vector<string>& messages, vector<string>& senders) {
        
        map<string, int> m;
        for (int i = 0; i < messages.size(); ++i) {
            stringstream ss(messages[i]);
            string 
        int max = 0;
        string res;
        for(auto it = m.begin(); it != m.end(); it++){
            if(it->second > max){
                max = it->second;
                res = it->first;
            }
            else if(it->second == max){
                res = (res < it->first) ? res : it->first;
            }
        }
        return res;
    }
};