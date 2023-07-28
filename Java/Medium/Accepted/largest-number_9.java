class Solution {
    public String largestNumber(int[] nums) {
        
        if(nums.length == 0) return "";
        if(nums.length == 1) return String.valueOf(nums[0]);
        String[] strNums = new String[nums.length];
        for(int i = 0; i < nums.length; i++) strNums[i] = String.valueOf(nums[i]);
        Arrays.sort(strNums, (a,b) -> {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        });
        if(strNums[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for(String s : strNums) sb.append(s);
        return sb.toString();
    }
}