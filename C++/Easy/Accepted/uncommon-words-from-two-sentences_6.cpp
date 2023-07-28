class Solution {
public:
    vector<string> uncommonFromSentences(string s1, string s2) {
        
        vector<string> result;
        map<string, int> map1;
        map<string, int> map2;
        string temp;
        for (int i = 0; i < s1.size(); i++) {
            if (s1[i] == ' ') {
                map1[temp]++;
                temp = "";
            } else {
                temp += s1[i];
            }
        }
        map1[temp]++;
        temp = "";
        for (int i = 0; i < s2.size(); i++) {
            if (s2[i] == ' ') {
                map2[temp]++;
                temp = "";
            } else {
                temp += s2[i];
            }
        }
        map2[temp]++;
        for (auto& item : map1) {
            if (item.second == 1 && map2.count(item.first) == 0) {
                result.push_back(item.first);
            }
        }
        for (auto& item : map2) {
            if (item.second == 1 && map1.count(item.first) == 0) {
                result.push_back(item.first);
            }
        }
        return result;
    }
};