class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        
        int[] result = new int[k];
        int[] sums = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int j = 0; j < mat[i].length; j++) {
                sum += mat[i][j];
            }
            sums[i] = sum;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < sums.length; i++) {
            if (!map.containsKey(sums[i])) {
                map.put(sums[i], new ArrayList<>());
            }
            map.get(sums[i]).add(i);
        }
        Arrays.sort(sums);
        int count = 0;
        for (int i = 0; i < sums.length; i++) {
            List<Integer> list = map.get(sums[i]);
            for (int j = 0; j < list.size(); j++) {
                if (count < k) {
                    result[count++] = list.get(j);
                } else {
                    return result;
                }
            }
        }
        return result;
    }
}