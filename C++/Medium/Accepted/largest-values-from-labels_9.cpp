class Solution {
public:
    int largestValsFromLabels(vector<int>& values, vector<int>& labels, int numWanted, int useLimit) {
        
        map<int, vector<int>> m;
        for (int i = 0; i < values.size(); i++) {
            m[values[i]].push_back(labels[i]);
        }
        map<int, int> use;
        int res = 0;
        for (auto it = m.rbegin(); it != m.rend(); it++) {
            for (int i = 0; i < it->second.size(); i++) {
                if (numWanted == 0) {
                    return res;
                }
                if (use[it->second[i]] < useLimit) {
                    res += it->first;
                    numWanted--;
                    use[it->second[i]]++;
                }
            }
        }
        return res;
    }
};