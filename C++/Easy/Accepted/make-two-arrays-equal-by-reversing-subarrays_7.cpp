class Solution {
public:
    bool canBeEqual(vector<int>& target, vector<int>& arr) {
        
        int n = target.size();
        int m = arr.size();
        if(n!=m)
            return false;
        unordered_map<int,int> mp;
        for(int i=0;i<n;i++){
            mp[target[i]]++;
            mp[arr[i]]--;
        }
        for(auto x:mp){
            if(x.second!=0)
                return false;
        }
        return true;
    }
};