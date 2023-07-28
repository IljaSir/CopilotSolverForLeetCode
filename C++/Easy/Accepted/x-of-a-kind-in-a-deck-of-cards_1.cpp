class Solution {
public:
    bool hasGroupsSizeX(vector<int>& deck) {
        
        map<int, int> mp;
        for (int i = 0; i < deck.size(); i++) {
            mp[deck[i]]++;
        }
        auto it = mp.begin();
        int x = it->second;
        it++;
        while (it != mp.end()) {
            x = gcd(x, it->second);
            if (x == 1) {
                return false;
            }
            it++;
        }
        return x > 1;
    }
    int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
};