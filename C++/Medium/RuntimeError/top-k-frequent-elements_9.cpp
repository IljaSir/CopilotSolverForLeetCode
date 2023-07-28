class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        
        // create a map to store the frequency of each element
        unordered_map<int, int> freq;
        for (int n : nums) {
            freq[n]++;
        }
        // create a vector of pairs to store the frequency and the element
        vector<pair<int, int>> vec;
        for (auto it = freq.begin(); it != freq.end(); it++) {
            vec.push_back(make_pair(it->second, it->first));
        }
        // sort the vector based on the frequency
        sort(vec.begin(), vec.end());
        // return the k most frequent elements
        vector<int> result;
        for (int i = vec.size() - 1; i >= vec.size() - k; i--) {
            result.push_back(vec[i].second);
        }
        return result;
    }
};