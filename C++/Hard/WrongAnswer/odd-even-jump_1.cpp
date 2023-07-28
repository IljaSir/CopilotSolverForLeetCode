class Solution {
public:
    int oddEvenJumps(vector<int>& arr) {
        
        int n = arr.size();
        vector<int> odd(n, -1);
        vector<int> even(n, -1);
        map<int, int> mp;
        mp[arr[n-1]] = n-1;
        odd[n-1] = even[n-1] = 1;
        for(int i = n-2; i >= 0; i--) {
            auto it = mp.lower_bound(arr[i]);
            if(it != mp.end()) {
                odd[i] = even[it->second];
            }
            it = mp.upper_bound(arr[i]);
            if(it != mp.begin()) {
                it--;
                even[i] = odd[it->second];
            }
            mp[arr[i]] = i;
        }
        return accumulate(odd.begin(), odd.end(), 0);
    }
};