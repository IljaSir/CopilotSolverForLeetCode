class Solution {
public:
    int wordCount(vector<string>& startWords, vector<string>& targetWords) {
        
        unturn count;
    }
    
    bool canConvert(string& start, string& target) {
        if (start.size() > target.size()) {
            return false;
        }
        if (start == target) {
            return true;
        }
        unordered_set<char> set;
        for (auto& c : start) {
            set.insert(c);
        }
        for (auto& c : target) {
            if (set.find(c) == set.end()) {
                set.insert(c);
                start.push_back(c);
            }
        }
        sort(start.begin(), start.end());
        sort(target.begin(), target.end());
        return start == target;
    }
};