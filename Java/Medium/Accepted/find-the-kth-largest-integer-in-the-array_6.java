class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        
        int n = nums.length;
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> {
            String sa = nums[a];
            String sb = nums[b];
            if (sa.length() != sb.length()) {
                return Integer.compare(sa.length(), sb.length());
            }
            return sa.compareTo(sb);
        });
        return nums[index[n - k]];
    }
}