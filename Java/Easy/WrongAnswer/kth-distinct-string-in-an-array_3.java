class Solution {
    public String kthDistinct(String[] arr, int k) {
        
        Set<String> set = new HashSet<>();
        for (String s: arr) {
            set.add(s);
            if (set.size() == k) {
                return s;
            }
        }
        return "";
    }
}