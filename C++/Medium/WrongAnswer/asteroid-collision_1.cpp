class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        
        stack<int> s;
        for (int i = 0; i < asteroids.size(); ++i) {
            if (asteroids[i] > 0) {
                s.push(asteroids[i]);
            } else {
                bool flag = true;
                while (!s.empty() && s.top() > 0 && s.top() < abs(asteroids[i])) {
                    s.pop();
                }
                if (!s.empty() && s.top() == abs(asteroids[i])) {
                    s.pop();
                    flag = false;
                }
                if (flag && (!s.empty() && s.top() > 0)) {
                    continue;
                } else {
                    s.push(asteroids[i]);
                }
            }
        }
        vector<int> ans;
        while (!s.empty()) {
            ans.push_back(s.top());
            s.pop();
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};