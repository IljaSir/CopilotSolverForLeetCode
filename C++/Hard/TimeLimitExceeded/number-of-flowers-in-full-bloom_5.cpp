class Solution {
public:
    vector<int> fullBloomFlowers(vector<vector<int>>& flowers, vector<int>& people) {
        
        vector<int> result;
        int flowerCount = flowers.size();
        for (auto person : people) {
            int count = 0;
            for (int i = 0; i < flowerCount; i++) {
                if (person >= flowers[i][0] && person <= flowers[i][1]) {
                    count++;
                }
            }
            result.push_back(count);
        }
        return result;
    }
};