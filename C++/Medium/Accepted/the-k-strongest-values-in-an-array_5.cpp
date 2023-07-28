class Solution {
public:
    vector<int> getStrongest(vector<int>& arr, int k) {
        
        sort(arr.begin(), arr.end());
        int n = arr.size();
        int median = arr[(n-1)/2];
        sort(arr.begin(), arr.end(), [median](int a, int b){
            if(abs(a-median) == abs(b-median)){
                return a > b;
            }
            return abs(a-median) > abs(b-median);
        });
        vector<int> res;
        for(int i = 0; i < k; i++){
            res.push_back(arr[i]);
        }
        return res;
    }
};