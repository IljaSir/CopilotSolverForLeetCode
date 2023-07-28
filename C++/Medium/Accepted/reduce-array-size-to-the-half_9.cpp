class Solution {
public:
    int minSetSize(vector<int>& arr) {
        
        unordered_map<int, int> cnt;
        for (int i : arr) {
            ++cnt[i];
        }

        vector<int> freq;
        for (auto& kv : cnt) {
            freq.push_back(kv.second);
        }

        sort(freq.begin(), freq.end(), greater<int>());
        int n = arr.size();
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < freq.size() && sum < n / 2; ++i) {
            sum += freq[i];
            ++ans;
        }

        return ans;
    }
};