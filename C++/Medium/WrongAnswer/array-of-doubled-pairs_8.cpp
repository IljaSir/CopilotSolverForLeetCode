class Solution {
public:
    bool canReorderDoubled(vector<int>& arr) {
        
        map<int, int> mp;
        for(auto &x: arr) mp[x] ++;
        for(auto &x: mp) {
            if(x.second == 0) continue;
            if(x.first < 0) {
                if(x.first % 2 == 1 || mp.find(x.first / 2) == mp.end() || mp[x.first / 2] < x.second) return false;
                mp[x.first / 2] -= x.second;
            } else {
                if(mp.find(2 * x.first) == mp.end() || mp[2 * x.first] < x.second) return false;
                mp[2 * x.first] -= x.second;
            }
        }
        return true;
    }
};