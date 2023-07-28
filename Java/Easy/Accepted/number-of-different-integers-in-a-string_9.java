class Solution {
    public int numDifferentIntegers(String word) {
        
        Set<String> set = new HashSet<>();
        String[] arr = word.split("[a-z]+");
        for(String s : arr){
            if(s.length() == 0) continue;
            set.add(s.replaceFirst("^0+(?!$)", ""));
        }
        return set.size();
    }
}