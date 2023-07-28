class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int[] piece : pieces) {
            int index = map.getOrDefault(piece[0], -1);
            if (index == -1) {
                return false;
            }
            for (int i = 1; i < piece.length; i++) {
                if (index + i >= arr.length || piece[i] != arr[index + i]) {
                    return false;
                }
            }
        }
        return true;
    }
}