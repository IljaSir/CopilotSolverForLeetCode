class Solution {
    public String kthDistinct(String[] arr, int k) {
        
        if (arr == null || arr.length == 0 || k > arr.length) {
            return "";
        }
        Set<String> set = new HashSet<>();
        for (String s : arr) {
            set.add(s);
        }
        if (set.size() < k) {
            return "";
        }
        List<String> list = new ArrayList<>(set);
        return list.get(k - 1);
    }
}