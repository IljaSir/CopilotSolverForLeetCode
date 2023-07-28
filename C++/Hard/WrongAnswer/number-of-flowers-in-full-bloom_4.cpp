class Solution {
public:
    vector<int> fullBloomFlowers(vector<vector<int>>& flowers, vector<int>& people) {
        
        vector<int> answer;
        int n = flowers.size();
        int m = people.size();
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (people[i] >= flowers[j][0] && people[i] <= flowers[j][1]) {
                answer.push_back(1);
                i++;
            } else if (people[i] > flowers[j][1]) {
                j++;
            } else {
                answer.push_back(0);
                i++;
            }
        }
        while (i < m) {
            answer.push_back(0);
            i++;
        }
        return answer;
    }
};