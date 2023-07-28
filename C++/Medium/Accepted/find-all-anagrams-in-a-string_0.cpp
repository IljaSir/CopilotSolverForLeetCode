class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        
        vector<int> res;
        unordered_map<char, int> m;
        for (char c : p) m[c]++;
        int left = 0, right = 0, count = m.size();
        while (right < s.size()) {
            if (m.count(s[right])) {
                m[s[right]]--;
                if (m[s[right]] == 0) count--;
            }
            right++;
            while (count == 0) {
                if (m.count(s[left])) {
                    m[s[left]]++;
                    if (m[s[left]] > 0) count++;
                }
                if (right - left == p.size()) res.push_back(left);
                left++;
            }
        }
        return res;
    }
};