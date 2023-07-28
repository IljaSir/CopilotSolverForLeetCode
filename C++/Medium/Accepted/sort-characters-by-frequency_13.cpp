class Solution {
public:
    string frequencySort(string s) {
        
        unordered_map<char, int> freq;
        for (auto c : s) {
            freq[c]++;
        }
        vector<pair<char, int>> vec;
        for (auto& p : freq) {
            vec.push_back(p);
        }
        sort(vec.begin(), vec.end(), [](const auto& a, const auto& b) {
            return a.second > b.second;
        });
        string res;
        for (auto& p : vec) {
            res.append(p.second, p.first);
        }
        return res;
    }
};