class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        int[] map = new int[200001];
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            map[arr[i] + 100000]++;
        }
        int rank = 1;
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) {
                map[i] = rank;
                rank++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            res[i] = map[arr[i] + 100000];
        }
        return res;
    }
}