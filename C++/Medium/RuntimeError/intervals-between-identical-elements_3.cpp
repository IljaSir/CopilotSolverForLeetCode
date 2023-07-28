class Solution {
public:
    vector<long long> getDistances(vector<int>& arr) {
        
        vector<long long> res(arr.size(), 0);
        unordered_map<int, vector<int>> map;
        for(int i = 0; i < arr.size(); i++) {
            map[arr[i]].push_back(i);
        }
        for(auto& p : map) {
            vector<int>& indices = p.second;
            for(int i = 0; i < indices.size(); i++) {
                int idx = indices[i];
                res[idx] += (i - 0) * 1LL * (indices[i] - indices[i - 1]);
                res[idx] += (indices.size() - i - 1) * 1LL * (indices[i + 1] - indices[i]);
            }
        }
        return res;
    }
    vector<long long> sumOfBeauties(vector<int>& arr) {
        vector<long long> res(arr.size(), 0);
        vector<long long> left = getDistances(arr);
        reverse(arr.begin(), arr.end());
        vector<long long> right = getDistances(arr);
        reverse(right.begin(), right.end());
        for(int i = 0; i < arr.size(); i++) {
            if(i == 0 || i == arr.size() - 1) {
                continue;
            }
            if(arr[i - 1] < arr[i] && arr[i] < arr[i + 1]) {
                res[i] = left[i] + right[i];
            }
        }
        return res;
    }
};