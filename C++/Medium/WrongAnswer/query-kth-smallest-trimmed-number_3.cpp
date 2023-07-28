class Solution {
public:
    vector<int> smallestTrimmedNumbers(vector<string>& nums, vector<vector<int>>& queries) {
        
        vector<int> answer;
        for (auto query : queries) {
            int k = query[0];
            int trim = query[1];
            vector<int> v;
            for (auto num : nums) {
                v.push_back(stoi(num.substr(0, num.length() - trim + 1)));
            }
            sort(v.begin(), v.end());
            answer.push_back(v[k - 1]);
        }
        return answer;
    }
};