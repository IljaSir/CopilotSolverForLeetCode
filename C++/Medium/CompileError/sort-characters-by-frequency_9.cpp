class Solution {
public:
    string frequencySort(string s) {
        
        unordered_map<char, int> freq;
        for (auto c: s) {
            freq[c]++;
        }
        vector<pair<int, char>> v;
        for (auto p: freq) {
            v.push_back({p.second, p.first});
        }
        sort(v.begin(), v.end(), [](const pair<int, char>& a, const pair<int, char>& b) {
            return a.first > b.first;
        });
        string ans;
        for (auto p: v) {
            ans.append(p.first, p.second);
        }
        return anir<int, char>> v;
        for (auto p : m) {
            v.push_back(make_pair(p.second, p.first));
        }
        sort(v.begin(), v.end(), [](pair<int, char> a, pair<int, char> b) {return a.first > b.first;});
        string res = "";
        for (auto p : v) {
            for (int i = 0; i < p.first; i++) {
                res += p.second;
            }
        }
        return res;
    }
};