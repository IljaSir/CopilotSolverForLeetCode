class Solution {
public:
    int minOperations(vector<int>& target, vector<int>& arr) {
        
        unordered_map<int,int> m;
        for(int i=0; i<target.size(); i++)
            m[target[i]] = i;
        vector<int> v;
        for(int i=0; i<arr.size(); i++){
            if(m.find(arr[i]) != m.end())
                v.push_back(m[arr[i]]);
        }
        return target.size() - lengthOfLIS(v);
    }
    int lengthOfLIS(vector<int>& nums) {
        if(nums.size() == 0)
            return 0;
        vector<int> v;
        v.push_back(nums[0]);
        for(int i=1; i<nums.size(); i++){
            if(nums[i] > v.back())
                v.push_back(nums[i]);
            else{
                int pos = lower_bound(v.begin(), v.end(), nums[i]) - v.begin();
                v[pos] = nums[i];
            }
        }
        return v.size();
    }
};