class Solution {
public:
    int countWords(vector<string>& words1, vector<string>& words2) {
        
        unordered_map<string, int> map1, map2;
        for (auto& word : words1) {
            if (map1.find(word) == map1.end()) {
                map1[word] = 1;
            } else {
                map1[word]++;
            }
        }
        for (auto& word : words2) {
            if (map2.find(word) == map2.end()) {
                map2[word] = 1;
            } else {
                map2[word]++;
            }
        }
        int count = 0;
        for (auto& kv : map1) {
            if (kv.second == 1 && map2.find(kv.first) != map2.end() && map2[kv.first] == 1) {
                count++;
            }
        }
        for (auto& kv : map2) {
            if (kv.second == 1 && map1.find(kv.first) != map1.end() && map1[kv.first] == 1) {
                count++;
            }
        }
        return count;
    }
};