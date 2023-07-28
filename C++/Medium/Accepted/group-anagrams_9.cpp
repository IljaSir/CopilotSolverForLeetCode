class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        
        vector<vector<string>> result;
        unordered_map<string, vector<string>> map;
        for (auto& str : strs) {
            string sorted_str = str;
            sort(sorted_str.begin(), sorted_str.end());
            map[sorted_str].push_back(str);
        }
        for (auto& [key, value] : map) {
            result.push_back(value);
        }
        return result;
    }
};