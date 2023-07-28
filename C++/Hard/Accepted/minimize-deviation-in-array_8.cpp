class Solution {
public:
    int minimumDeviation(vector<int>& nums) {
        
        multiset<int> s;
        for(int i:nums) {
            if(i%2==0) s.insert(i);
            else s.insert(i*2);
        }
        int res = *s.rbegin() - *s.begin();
        while(*s.rbegin()%2==0) {
            int n = *s.rbegin();
            s.erase(--s.end());
            s.insert(n/2);
            res = min(res, *s.rbegin() - *s.begin());
        }
        return res;
    }
};