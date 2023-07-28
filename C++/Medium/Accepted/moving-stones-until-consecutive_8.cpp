class Solution {
public:
    vector<int> numMovesStones(int a, int b, int c) {
        
        int arr[3] = {a,b,c};
        sort(arr, arr+3);
        int min = 0;
        int max = 0;
        if(arr[1] - arr[0] == 1 && arr[2] - arr[1] == 1){
            min = 0;
        }else if(arr[1] - arr[0] == 1 || arr[2] - arr[1] == 1 || arr[1] - arr[0] == 2 || arr[2] - arr[1] == 2){
            min = 1;
        }else{
            min = 2;
        }
        max = arr[1] - arr[0] - 1 + arr[2] - arr[1] - 1;
        return {min, max};
    }
};