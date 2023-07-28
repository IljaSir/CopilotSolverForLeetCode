class Solution {
public:
    int findTheDistanceValue(vector<int>& arr1, vector<int>& arr2, int d) {
        
        vector<int> arr3;
        for(int i=0;i<arr1.size();i++){
            for(int j=0;j<arr2.size();j++){
                arr3.push_back(abs(arr1[i]-arr2[j]));
            }
        }
        int count=0;
        for(int i=0;i<arr3.size();i++){
            if(arr3[i]>d){
                count++;
            }
        }
        return count;
    }
};