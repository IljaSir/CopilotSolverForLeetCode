class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        
        int n = nums.size();
        int max = 0;
        for (List<Integer> list : nums) {
            max += list.size();
        }
        int[] result = new int[max];
        int index = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < nums.get(i).size(); ++j) {
                result[index++] = nums.get(i).get(j);
            }
        }
        return result;
    }
}