class Solution {
public:
    int distinctAverages(vector<int>& nums) {
        
        map<int, int> mp;
        for (const auto& num : nums) {
            mp[num]++;
        }
        set<float> ave;
        for (const auto& [num, cnt] : mp) {
            vector<int> tmp;
            for (const auto& [num2, cnt2] : mp) {
                if (num2 == num) {
                    if (cnt2 > 1) {
                        tmp.push_back(num2);
                        tmp.push_back(num2);
                    }
                } else {
                    tmp.push_back(num2);
                    tmp.push_back(num2);
                }
            }
            for (int i = 0; i < tmp.size(); ++i) {
                for (int j = i + 1; j < tmp.size(); ++j) {
                    ave.insert((tmp[i] + tmp[j]) / 2.0);
                }
            }
        }
        return ave.size();
    }
};