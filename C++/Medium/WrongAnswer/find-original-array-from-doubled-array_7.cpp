class Solution {
public:
    vector<int> findOriginalArray(vector<int>& changed) {
        
        vector<int> result;
        if (changed.size() % 2 == 1) return result;
        map<int, int> count;
        for (auto c : changed) {
            count[c]++;
        }
        for (auto c : changed) {
            if (count[c] == 0) continue;
            if (count[c * 2] == 0) return vector<int>();
            count[c]--;
            count[c * 2]--;
            result.push_back(c);
        }
        return result;
    }
};