class Solution {
public:
    int minimumRounds(vector<int>& tasks) {
        
        map<int, int> m;
        for (int a : tasks) {
            m[a]++;
        }
        int ans = 0;
        for (auto& p : m) {
            int a = p.first, b = p.second;
            int c = 0;
            if (b % 2 == 1) {
                c = 1;
                b--;
            }
            ans += b / 2 + c;
        }
        return ans;
    }
};