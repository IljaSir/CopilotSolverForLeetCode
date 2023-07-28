class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        
        int k = nums.size();
        int[] idxs = new int[k];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            min = Math.min(min, nums.get(i).get(0));
            max = Math.max(max, nums.get(i).get(0));
        }
        int[] res = {min, max};
        while (true) {
            int minIdx = 0, minVal = Integer.MAX_VALUE;
            for (int i = 0; i < k; i++) {
                if (idxs[i] < nums.get(i).size() && nums.get(i).get(idxs[i]) < minVal) {
                    minVal = nums.get(i).get(idxs[i]);
                    minIdx = i;
                }
            }
            idxs[minIdx]++;
            if (idxs[minIdx] == nums.get(minIdx).size()) break;
            min = Math.min(min, nums.get(minIdx).get(idxs[minIdx]));
            max = Math.max(max, nums.get(minIdx).get(idxs[minIdx]));
            if (max - min < res[1] - res[0]) {
                res[0] = min;
                res[1] = max;
            }
        }
        return res;
    }
}