class Solution {
public:
    vector<string> sortPeople(vector<string>& names, vector<int>& heights) {
        
        vector<string> result;
        vector<pair<int, string>> sorted;
        for (int i = 0; i < names.size(); i++) {
            sorted.push_back({heights[i], names[i]});
        }
        sort(sorted.begin(), sorted.end());
        for (auto& s : sorted) {
            result.push_back(s.second);
        }
        reverse(result.begin(), result.end());
        return result;
    }
};