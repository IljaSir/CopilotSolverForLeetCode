class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        int rank = 1;
        Map<Integer, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < sorted.length; i++) {
            if (i == 0 || sorted[i] != sorted[i - 1]) {
                rankMap.put(sorted[i], rank++);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rankMap.get(arr[i]);
        }
        return arr;
    }
}