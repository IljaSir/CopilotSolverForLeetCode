class Solution {
    public String kthDistinct(String[] arr, int k) {
        
        Set<String> set = new HashSet<>();
        for (String s : arr) {
            if (set.add(s)) {
                k--;
                if (k == 0) {
                    return s;
                }
            }
        }
        return "";
    }
}