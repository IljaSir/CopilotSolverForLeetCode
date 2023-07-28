class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    return s1.length() - s2.length();
                } else {
                    return s1.compareTo(s2);
                }
            }
        });
        return nums[nums.length - k];
    }
}