class Solution {
public:
    int minimumDeviation(vector<int>& nums) {
        
        multiset<int> s;
        for (int x : nums) {
            if (x % 2) x *= 2;
            s.insert(x);
        }
        int ans = *s.rbegin() - *s.begin();
        while (*s.rbegin() % 2 == 0) {
            int x = *s.rbegin();
            s.erase(s.find(x));
            s.insert(x / 2);
            ans = min(ans, *s.rbegin() - *s.begin());
        }
        return ans;
    }
};