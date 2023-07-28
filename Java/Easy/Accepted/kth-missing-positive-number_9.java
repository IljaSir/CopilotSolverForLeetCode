class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        int i = 0;
        int count = 0;
        int number = 1;
        while (count < k) {
            if (i < arr.length && arr[i] == number) {
                i++;
            } else {
                count++;
            }
            number++;
        }
        return number - 1;
    }
}