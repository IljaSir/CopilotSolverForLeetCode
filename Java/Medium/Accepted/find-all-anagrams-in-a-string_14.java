class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result = new ArrayList<>();
        int[] arr = new int[26];
        int[] arr2 = new int[26];
        for (char c : p.toCharArray()) {
            arr[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            arr2[s.charAt(i) - 'a']++;
            if (i >= p.length()) {
                arr2[s.charAt(i - p.length()) - 'a']--;
            }
            if (Arrays.equals(arr, arr2)) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}