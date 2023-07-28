class Solution {
public:
    int getKth(int lo, int hi, int k) {
        
        vector<pair<int, int>> powers;
        for (int i = lo; i <= hi; i++) {
            powers.push_back({i, power(i)});
        }
        sort(powers.begin(), powers.end(), [](const pair<int, int> &a, const pair<int, int> &b) {
            return a.second < b.second || (a.second == b.second && a.first < b.first);
        });
        return powers[k - 1].first;
    }
};