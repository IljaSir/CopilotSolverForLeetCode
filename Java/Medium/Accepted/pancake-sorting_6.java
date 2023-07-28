class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        
        List<Integer> result = new ArrayList<Integer>();
        int n = arr.length;
        for (int i = n; i > 0; i--) {
            int index = findIndex(arr, i);
            if (index == i - 1) {
                continue;
            }
            result.add(index + 1);
            flip(arr, index + 1);
            result.add(i);
            flip(arr, i);
        }
        return result;
    }

    public int findIndex(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public void flip(int[] arr, int k) {
        int i = 0, j = k - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}