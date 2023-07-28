class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        
        List<Integer> result = new ArrayList<>();
        int[] arr = new int[1 << n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == start) {
                break;
            }
            i++;
        }
        int j = i;
        while (j < arr.length) {
            result.add(arr[j]);
            j++;
        }
        j = 0;
        while (j < i) {
            result.add(arr[j]);
            j++;
        }
        return result;
    }
}