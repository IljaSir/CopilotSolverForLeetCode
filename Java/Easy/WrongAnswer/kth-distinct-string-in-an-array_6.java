class Solution {
    public String kthDistinct(String[] arr, int k) {
        
        int count = 0;
        Set<String> set = new HashSet<>();
        for (String s : arr) {
            if (set.add(s)) {
                count++;
                if (count == k) {
                    return s;
                }
            }
        }
        return "";
    }
}