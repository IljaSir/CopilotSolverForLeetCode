class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        
        int min, max;
        int[] arr = new int[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        Arrays.sort(arr);
        if(arr[0] + 1 == arr[1] && arr[1] + 1 == arr[2]){
            min = 0;
        }else if(arr[0] + 1 == arr[1] || arr[1] + 1 == arr[2]){
            min = 1;
        }else if(arr[0] + 2 == arr[1] || arr[1] + 2 == arr[2]){
            min = 1;
        }else{
            min = 2;
        }
        max = arr[2] - arr[0] - 2;
        return new int[]{min, max};
    }
}