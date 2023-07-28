class Solution {
public:
    vector<int> arrayRankTransform(vector<int>& arr) {
        
        map<int, int> rank;
        for (auto& i : arr) {
            rank[i] = 0;
        }
        int count = 1;
        for (auto& i : rank) {
            i.second = count++;
        }
        for (auto& i : arr) {
            i = rank[i];
        }
        return arr;
    }
};