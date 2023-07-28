class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        
        List<Integer> indices = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                map.put(i, 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(i)) {
                indices.add(i);
            } else {
                boolean found = false;
                for (int j : map.keySet()) {
                    if (Math.abs(j - i) <= k) {
                        indices.add(i);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    indices.add(-1);
                }
            }
        }
        return indices;
    }
}