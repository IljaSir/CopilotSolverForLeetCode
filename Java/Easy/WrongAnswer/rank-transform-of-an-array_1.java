class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        Arrays.sort(temp);
        int rank = 1;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || temp[i] != temp[i - 1]) {
                rank++;
            }
            arr[i] = rank;
        }
        return arr;
    }
}