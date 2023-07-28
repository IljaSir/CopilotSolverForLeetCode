class Solution {
public:
    vector<int> getStrongest(vector<int>& arr, int k) {
        
        vector<int> res;
        int median = findMedian(arr);
        sort(arr.begin(), arr.end(), [&](int a, int b){
            return abs(a-median)>abs(b-median) || (abs(a-median)==abs(b-median) && a>b);
        });
        for(int i=0;i<k;i++) res.push_back(arr[i]);
        return res;
    }
};