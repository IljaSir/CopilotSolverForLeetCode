class Solution {
public:
    bool canReorderDoubled(vector<int>& arr) {
        
        int n = arr.size();
        if (n % 2 != 0) return false;
        unordered_map<int, int> mp;
        sort(arr.begin(), arr.end());
        for (int i = 0; i < n; i++) {
            mp[arr[i]]++;
        }
        for (int i = 0; i < n; i++) {
            if (mp[arr[i]] > 0) {
                if (arr[i] < 0) {
                    if (mp[arr[i] / 2] == 0) return false;
                    mp[arr[i] / 2]--;
                }
                else {
                    if (mp[arr[i] * 2] == 0) return false;
                    mp[arr[i] * 2]--;
                }
                mp[arr[i]]--;
            }
        }
        return true;
    }
};