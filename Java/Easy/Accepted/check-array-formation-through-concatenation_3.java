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
            int index = map.get(piece[0]);
            for (int i = 0; i < piece.length; i++) {
                if (index >= arr.length || arr[index] != piece[i]) {
                    return false;
                }
                index++;
            }
        }
        return true;
    }
}