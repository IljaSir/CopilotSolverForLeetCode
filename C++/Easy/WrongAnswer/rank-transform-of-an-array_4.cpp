class Solution {
public:
    vector<int> arrayRankTransform(vector<int>& arr) {
        
        vector<int> sorted = arr;
        sort(sorted.begin(), sorted.end());
        unordered_map<int, int> rank;
        for(int i = 0; i < sorted.size(); i++){
            if(rank.find(sorted[i]) == rank.end()){
                rank[sorted[i]] = i + 1;
            }
        }
        for(int i = 0; i < arr.size(); i++){
            arr[i] = rank[arr[i]];
        }
        return arr;
    }
};