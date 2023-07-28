class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        helper(ans, temp, s, 0);
        return ans;
    }
    
    public void helper(List<List<String>> ans, List<String> temp, String s, int start){
        if(start == s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = start; i < s.length(); i++){
            if(isPalindrome(s, start, i)){
                temp.add(s.substring(start, i + 1));
                helper(ans, temp, s, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}