class Solution {
public:
    bool hasGroupsSizeX(vector<int>& deck) {
        
        unordered_map<int, int> freq;
        for(int i : deck) {
            freq[i]++;
        }
        int gcd = 0;
        for(auto f : freq) {
            gcd = __gcd(gcd, f.second);
        }
        return gcd > 1;
    }
};