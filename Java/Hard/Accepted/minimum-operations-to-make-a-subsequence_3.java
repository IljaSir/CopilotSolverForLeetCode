class Solution {
    public int minOperations(int[] target, int[] arr) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            map.put(target[i], i);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                list.add(map.get(arr[i]));
            }
        }
        return target.length - lengthOfLIS(list);
    }
    private int lengthOfLIS(List<Integer> nums) {
        int[] tails = new int[nums.size()];
        int size = 0;
        for (int x: nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = x;
            if (i == size) {
                ++size;
            }
        }
        return size;
    }
}