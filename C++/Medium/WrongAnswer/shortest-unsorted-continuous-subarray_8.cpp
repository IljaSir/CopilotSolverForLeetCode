class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        
        int n = nums.size();
        int l = n-1, r = 0;
        stack<int> s;
        for(int i = 0; i < n; i++) {
            while(!s.empty() && nums[s.top()] > nums[i]) {
                l = min(l, s.top());
                s.pop();
            }
            s.push(i);
        }
        while(!s.empty()) s.pop();
        for(int i = n-1; i >= 0; i--) {
            while(!s.empty() && nums[s.top()] < nums[i]) {
                r = max(r, s.top());
                s.pop();
            }
            s.push(i);
        }
        return max(0, r-l+1);
    }
};