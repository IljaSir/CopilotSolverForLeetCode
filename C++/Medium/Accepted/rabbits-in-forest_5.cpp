class Solution {
public:
    int numRabbits(vector<int>& answers) {
        
        int ans = 0;
        unordered_map<int, int> m;
        for(int i = 0; i < answers.size(); i++){
            m[answers[i]]++;
        }
        for(auto it = m.begin(); it != m.end(); it++){
            int key = it->first;
            int value = it->second;
            ans += (value + key) / (key + 1) * (key + 1);
        }
        return ans;
    }
};