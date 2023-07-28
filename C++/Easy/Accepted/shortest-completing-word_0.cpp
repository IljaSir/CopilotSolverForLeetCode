class Solution {
public:
    string shortestCompletingWord(string licensePlate, vector<string>& words) {
        
        unordered_map<char, int> mp;
        for (int i = 0; i < licensePlate.size(); i++) {
            if (isalpha(licensePlate[i])) {
                mp[tolower(licensePlate[i])]++;
            }
        }
        string res = "";
        for (int i = 0; i < words.size(); i++) {
            unordered_map<char, int> temp = mp;
            for (int j = 0; j < words[i].size(); j++) {
                if (temp.find(words[i][j]) != temp.end()) {
                    temp[words[i][j]]--;
                    if (temp[words[i][j]] == 0) {
                        temp.erase(words[i][j]);
                    }
                }
            }
            if (temp.empty() && (res.empty() || res.size() > words[i].size())) {
                res = words[i];
            }
        }
        return res;
    }
};