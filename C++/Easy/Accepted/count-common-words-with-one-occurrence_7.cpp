class Solution {
public:
    int countWords(vector<string>& words1, vector<string>& words2) {
        
        int count = 0;
        unordered_map<string, int> m1;
        unordered_map<string, int> m2;
        for (string& word : words1) {
            m1[word]++;
        }
        for (string& word : words2) {
            m2[word]++;
        }
        for (auto& i : m1) {
            if (m2.find(i.first) != m2.end() && i.second == 1 && m2[i.first] == 1) {
                count++;
            }
        }
        return count;
    }
};