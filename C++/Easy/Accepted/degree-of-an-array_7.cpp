class Solution {
public:
    int findShortestSubArray(vector<int>& nums) {
        
        map<int, vector<int>> m;
        for(int i = 0; i < nums.size(); i++) {
            m[nums[i]].push_back(i);
        }
        int max = 0;
        int min = 50000;
        for(auto i = m.begin(); i != m.end(); i++) {
            if(i->second.size() > max) {
                max = i->second.size();
            }
        }
        for(auto i = m.begin(); i != m.end(); i++) {
            if(i->second.size() == max) {
                if(i->second.back() - i->second.front() < min) {
                    min = i->second.back() - i->second.front();
                }
            }
        }
        return min+1;
    }
};