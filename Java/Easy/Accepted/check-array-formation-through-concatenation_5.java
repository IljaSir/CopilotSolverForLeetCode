class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }
        int i = 0;
        while (i < arr.length) {
            if (!map.containsKey(arr[i])) {
                return false;
            }
            int[] piece = map.get(arr[i]);
            for (int p : piece) {
                if (p != arr[i]) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}