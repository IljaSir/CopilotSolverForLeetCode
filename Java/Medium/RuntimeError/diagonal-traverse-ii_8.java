class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        
        // use a map to store the sum of row and col
        // when row + col = 0, then it's the first row
        // when row + col = 1, then it's the second row
        // when row + col = n, then it's the last row
        // when row + col = n - 1, then it's the last second row
        // so the sum of row and col is the key of the map
        Map<Integer, List<Integer>> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int sum = i + j;
                if (!map.containsKey(sum)) {
                    map.put(sum, new ArrayList<>());
                }
                map.get(sum).add(nums.get(i).get(j));
                max = Math.max(max, sum);
            }
        }
        int[] res = new int[nums.size()];
        int index = 0;
        for (int i = 0; i <= max; i++) {
            List<Integer> list = map.get(i);
            for (int j = list.size() - 1; j >= 0; j--) {
                res[index++] = list.get(j);
            }
        }
        return res;
    }
}