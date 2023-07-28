class Solution {
public:
    int maxChunksToSorted(vector<int>& arr) {
        
        int n = arr.size();
        vector<int> a(n);
        for (int i = 0; i < n; i++) {
            a[i] = arr[i];
        }
        sort(a.begin(), a.end());
        unordered_map<int, int> cnt;
        int res = 0;
        for (int i = 0; i < n; i++) {
            cnt[a[i]]++;
            cnt[arr[i]]--;
            if (cnt[a[i]] == 0) {
                cnt.erase(a[i]);
            }
            if (cnt[arr[i]] == 0) {
                cnt.erase(arr[i]);
            }
            if (cnt.empty()) {
                res++;
            }
        }
        return res;
    }
};