class Solution {
public:
    vector<string> reorderLogFiles(vector<string>& logs) {
        
        vector<string> result;
        vector<string> digitlogs;
        vector<pair<string, string>> letterlogs;
        for(auto log: logs){
            int i = 0;
            while(i < log.size() && log[i] != ' '){
                i++;
            }
            if(isdigit(log[i+1])){
                digitlogs.push_back(log);
            }
            else{
                letterlogs.push_back({log.substr(0, i), log.substr(i+1)});
            }
        }
        sort(letterlogs.begin(), letterlogs.end(), [](pair<string, string> a, pair<string, string> b){
            return a.second < b.second || (a.second == b.second && a.first < b.first);
        });
        for(auto log: letterlogs){
            result.push_back(log.first + " " + log.second);
        }
        for(auto log: digitlogs){
            result.push_back(log);
        }
        return result;
    }
};