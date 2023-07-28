class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int[] piece : pieces) {
            if (!map.containsKey(piece[0])) {
                return false;
            }
            int start = map.get(piece[0]);
            for (int i = 0; i < piece.length; i++) {
                if (start + i >= arr.length || arr[start + i] != piece[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}