class Solution {
    public int[] movesToStamp(String stamp, String target) {
        
        int n = target.length();
        boolean[] done = new boolean[n];
        char[] t = target.toCharArray();
        char[] s = stamp.toCharArray();
        List<Integer> ans = new ArrayList<>();
        while(true){
            boolean found = false;
            for(int i=0; i<=n-s.length; i++){
                if(!done[i] && canTransform(t, s, i)){
                    found = true;
                    done[i] = true;
                    ans.add(i);
                    for(int j=i; j<i+s.length; j++){
                        t[j] = '?';
                    }
                }
            }
            if(!found){
                break;
            }
        }
        for(int i=0; i<n; i++){
            if(t[i]!='?'){
                return new int[0];
            }
        }
        Collections.reverse(ans);
        return ans.stream().mapToInt(i->i).toArray();
    }
    
    private boolean canTransform(char[] t, char[] s, int i){
        int n = s.length;
        for(int j=0; j<n; j++){
            if(t[i+j]!='?' && t[i+j]!=s[j]){
                return false;
            }
        }
        return true;
    }
}