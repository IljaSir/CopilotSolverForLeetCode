class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        
        vector<int> s;
        for(auto a : asteroids) {
            if(a > 0) {
                s.push_back(a);
            } else {
                while(!s.empty() && s.back() > 0 && s.back() < -a) {
                    s.pop_back();
                }
                if(s.empty() || s.back() < 0) {
                    s.push_back(a);
                } else if(s.back() == -a) {
                    s.pop_back();
                }
            }
        }
        return s;
    }
};