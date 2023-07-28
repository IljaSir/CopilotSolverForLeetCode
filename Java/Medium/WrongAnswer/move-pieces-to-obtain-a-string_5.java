class Solution {
    public boolean canChange(String start, String target) {
        
        int count = 0;
        for(int i = 0; i < start.length(); i++){
            if(start.charAt(i) != target.charAt(i)){
                count++;
            }
        }
        return count % 2 == 0;
    }
    public boolean canTransform(String start, String target) {
        if(!canChange(start, target)){
            return false;
        }
        int n = start.length();
        int i = 0, j = 0;
        while(i < n && j < n){
            while(i < n && start.charAt(i) == '_'){
                i++;
            }
            while(j < n && target.charAt(j) == '_'){
                j++;
            }
            if(i == n && j == n){
                return true;
            }
            if(i == n || j == n){
                return false;
            }
            if(start.charAt(i) != target.charAt(j)){
                return false;
            }
            if(start.charAt(i) == 'L' && i < j){
                return false;
            }
            if(start.charAt(i) == 'R' && i > j){
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}