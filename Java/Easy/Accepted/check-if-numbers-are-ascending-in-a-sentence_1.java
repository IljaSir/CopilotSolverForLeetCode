class Solution {
    public boolean areNumbersAscending(String s) {
        
        String[] arr = s.split(" ");
        int prev = 0;
        for (int i = 0; i < arr.length; i++) {
            try {
                int curr = Integer.parseInt(arr[i]);
                if (curr <= prev) {
                    return false;
                }
                prev = curr;
            } catch (Exception e) {
                
            }
        }
        return true;
    }
}