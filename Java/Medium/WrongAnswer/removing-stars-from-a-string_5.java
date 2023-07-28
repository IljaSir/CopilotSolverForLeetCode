class Solution {
    public String removeStars(String s) {
        
        int n = s.length();
        ArrayList<Integer> stars = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '*') {
                stars.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for(int i = 0; i < n; i++) {
            if(j < stars.size() && i == stars.get(j)) {
                j++;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}