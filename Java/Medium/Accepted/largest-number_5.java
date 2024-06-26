class Solution {
    public String largestNumber(int[] nums) {
        
        String[] arr = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String s : arr) {
            sb.append(s);
        }
        String res = sb.toString();
        return res.charAt(0) == '0' ? "0" : res;
    }
}