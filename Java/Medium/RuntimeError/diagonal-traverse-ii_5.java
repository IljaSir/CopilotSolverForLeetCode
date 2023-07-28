class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        
        int max = 0;
        for (List<Integer> list : nums) {
            max += list.size();
        }
        int[] res = new int[max];
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < max) {
            if (i < nums.size() && j < nums.get(i).size()) {
                res[k++] = nums.get(i).get(j);
                i--;
                j++;
            } else if (i == nums.size()) {
                i--;
                j += 2;
            } else {
                i++;
                if (j == nums.get(i).size()) {
                    j--;
                }
            }
            if (i < 0) {
                i = 0;
                j++;
            }
        }
        return res;
    }
}