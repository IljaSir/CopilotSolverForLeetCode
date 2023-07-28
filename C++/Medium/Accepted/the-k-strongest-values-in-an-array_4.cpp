class Solution {
public:
    vector<int> getStrongest(vector<int>& arr, int k) {
        
        sort(arr.begin(), arr.end());
        int mid = arr[(arr.size()-1)/2];
        sort(arr.begin(), arr.end(), [&](int a, int b){
            return abs(a-mid) > abs(b-mid) || (abs(a-mid) == abs(b-mid) && a > b);
        });
        vector<int> res;
        for(int i = 0; i < k; i++) res.push_back(arr[i]);
        return res;
    }
};