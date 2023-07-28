class Solution {
public:
    bool hasGroupsSizeX(vector<int>& deck) {
        
        map<int,int> m;
        for(int i=0;i<deck.size();i++){
            m[deck[i]]++;
        }
        int x = m.begin()->second;
        for(auto i=m.begin();i!=m.end();i++){
            x = __gcd(x,i->second);
            if(x == 1)
                return false;
        }
        return true;
    }
};