class Solution {
public:
    vector<int> fullBloomFlowers(vector<vector<int>>& flowers, vector<int>& people) {
        
        vector<int> ans(people.size(), 0);
        sort(flowers.begin(), flowers.end(), [](vector<int>& a, vector<int>& b) {return a[1] < b[1];});
        sort(people.begin(), people.end());
        int i = 0, j = 0;
        while (i < people.size() && j < flowers.size()) {
            if (people[i] <= flowers[j][1]) {
                int count = 0;
                for (int k = j; k >= 0 && flowers[k][1] >= people[i]; k--) {
                    if (flowers[k][0] <= people[i]) {
                        count++;
                    }
                }
                ans[i] = count;
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }
};