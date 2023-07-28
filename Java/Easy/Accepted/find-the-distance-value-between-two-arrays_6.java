class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            int temp = arr1[i];
            boolean flag = true;
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(temp - arr2[j]) <= d) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }
}