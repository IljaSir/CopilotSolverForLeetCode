class Solution {
    public int passThePillow(int n, int time) {
        
        int[] arr = new int[n];
        int index = 0;
        int i = 0;
        while (i < time) {
            arr[index]++;
            if (index == 0) {
                index++;
            } else if (index == n - 1) {
                index--;
            } else {
                if (arr[index] % 2 == 0) {
                    index--;
                } else {
                    index++;
                }
            }
            i++;
        }
        return index + 1;
    }
}