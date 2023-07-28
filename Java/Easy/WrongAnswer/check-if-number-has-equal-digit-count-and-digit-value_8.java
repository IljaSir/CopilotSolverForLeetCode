class Solution {
    public boolean digitCount(String num) {
        
        int[] arr = new int[10];
        for(char c: num.toCharArray()){
            arr[c-'0']++;
        }
        for(int i=0; i<10; i++){
            if(arr[i] != 0 && arr[i] != i) return false;
        }
        return true;
    }
}