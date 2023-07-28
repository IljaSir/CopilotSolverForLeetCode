class Solution {
public:
    int minimumDeviation(vector<int>& nums) {
        
        set<int> s;
        for (int num : nums) {
            num = num % 2 == 0 ? num : num * 2;
            s.insert(num);
        }
        int res = *s.rbegin() - *s.begin();
        while (*s.rbegin() % 2 == 0) {
            s.insert(*s.rbegin() / 2);
            s.erase(*s.rbegin());
            res = min(res, *s.rbegin() - *s.begin());
        }
        return res;
    }
};