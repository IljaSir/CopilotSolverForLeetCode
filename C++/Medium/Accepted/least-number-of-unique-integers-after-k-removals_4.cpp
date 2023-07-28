class Solution {
public:
    int findLeastNumOfUniqueInts(vector<int>& arr, int k) {
        
        unordered_map<int, int> counter;
        for (auto a: arr) {
            counter[a]++;
        }
        vector<int> counts;
        for (auto c: counter) {
            counts.push_back(c.second);
        }
        sort(counts.begin(), counts.end());
        int i = 0;
        while (i < counts.size() && k >= counts[i]) {
            k -= counts[i];
            i++;
        }
        return counts.size() - i;
    }
};