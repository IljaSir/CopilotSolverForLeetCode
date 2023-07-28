class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        
        map<int, int> count;
        map<int, int> freq;
        for (int i = 0; i < arr.size(); i++) {
            count[arr[i]]++;
        }
        for (auto it = count.begin(); it != count.end(); it++) {
            freq[it->second]++;
        }
        for (auto it = freq.begin(); it != freq.end(); it++) {
            if (it->second > 1) {
                return false;
            }
        }
        return true;
    }
};