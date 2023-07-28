class Solution {
public:
    int findSpecialInteger(vector<int>& arr) {
        
        int n = arr.size();
        for(int i = 0; i < n; i++){
            int j = i;
            while(j < n && arr[j] == arr[i]) j++;
            if(j - i > n / 4) return arr[i];
            i = j - 1;
        }
        return -1;
    }
};