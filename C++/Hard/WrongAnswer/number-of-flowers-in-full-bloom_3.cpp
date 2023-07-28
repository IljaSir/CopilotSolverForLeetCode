class Solution {
public:
    vector<int> fullBloomFlowers(vector<vector<int>>& flowers, vector<int>& people) {
        
        vector<int> res;
        int n = flowers.size();
        int m = people.size();
        int i = 0, j = 0;
        int cnt = 0;
        sort(flowers.begin(), flowers.end());
        sort(people.begin(), people.end());
        while (i < n && j < m) {
            if (people[j] < flowers[i][0]) {
                res.push_back(cnt);
                j++;
            } else if (people[j] <= flowers[i][1]) {
                cnt++;
                j++;
            } else {
                i++;
                cnt--;
            }
        }
        while (j < m) {
            res.push_back(cnt);
            j++;
        }
        return res;
    }
};