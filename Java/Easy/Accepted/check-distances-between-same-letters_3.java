class Solution {
    public boolean checkDistances(String s, int[] distance) {
        
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                int first = s.indexOf((char) ('a' + i));
                int second = s.indexOf((char) ('a' + i), first + 1);
                if (second - first - 1 != distance[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}