class Solution {
public:
    int largestComponentSize(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> parent(n);
        for(int i=0; i<n; i++) parent[i] = i;
        unordered_map<int, int> mp;
        for(int i=0; i<n; i++){
            int num = nums[i];
            for(int j=2; j*j<=num; j++){
                if(num%j == 0){
                    if(mp.count(j) == 0) mp[j] = i;
                    else{
                        int p = findParent(mp[j], parent);
                        parent[i] = p;
                    }
                    if(mp.count(num/j) == 0) mp[num/j] = i;
                    else{
                        int p = findParent(mp[num/j], parent);
                        parent[i] = p;
                    }
                }
            }
            if(mp.count(num) == 0) mp[num] = i;
            else{
                int p = findParent(mp[num], parent);
                parent[i] = p;
            }
        }
        unordered_map<int, int> cnt;
        for(int i=0; i<n; i++){
            int p = findParent(i, parent);
            cnt[p]++;
        }
        int res = 0;
        for(auto it : cnt) res = max(res, it.second);
        return res;
    }
};