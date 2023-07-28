class Solution {
public:
    bool canArrange(vector<int>& arr, int k) {
        
        int n = arr.size();
        vector<int> cnt(k,0);
        for(auto i:arr) {
            int t = i%k;
            if(t<0) t+=k;
            cnt[t]++;
        }
        if(cnt[0]%2!=0) return false;
        for(int i = 1;i<k;i++) {
            if(cnt[i]!=cnt[k-i]) return false;
        }
        return true;
    }
};