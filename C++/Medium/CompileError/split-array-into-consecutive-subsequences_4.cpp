class Solution {
public:
    bool isPossible(vector<int>& nums) {
        
        unordered_map<int, int> freq, appendfreq;
        for (int num : nums) {
            if (m.find(num) == m.end()) {
                m[num] = priority_queue<int, vector<int>, greater<int>>();
            }
            if (m.find(num - 1) != m.end()) {
                int prevLen = m[num - 1].top();
                m[num - 1].pop();
                if (m[num - 1].empty()) {
                    m.erase(num - 1);
                }
                m[num].push(prevLen + 1);
            } else {
                m[num].push(1);
            }
            }
            freq[x]--;
    }
        return true;
    }
};