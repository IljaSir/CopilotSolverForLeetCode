class Solution {
    public String kthDistinct(String[] arr, int k) {
        
        Set<String> set = new HashSet<>();
        for (String s : arr) {
            set.add(s);
        }
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        return k <= list.size() ? list.get(k - 1) : "";
    }
}