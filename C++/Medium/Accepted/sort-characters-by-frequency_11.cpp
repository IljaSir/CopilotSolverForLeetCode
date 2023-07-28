class Solution {
public:
    string frequencySort(string s) {
        
        unordered_map<char, int> freq;
        for (char c : s) {
            freq[c]++;
        }
        vector<pair<char, int>> v;
        for (auto it : freq) {
            v.push_back(it);
        }
        sort(v.begin(), v.end(), [](pair<char, int> a, pair<char, int> b) {
            return a.second > b.second;
        });
        string res;
        for (auto it : v) {
            for (int i = 0; i < it.second; i++) {
                res += it.first;
            }
        }
        return res;
    }
};