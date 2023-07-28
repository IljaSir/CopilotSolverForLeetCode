class Solution {
    public boolean equationsPossible(String[] equations) {
        
        int[] parent = new int[26];
        for(int i=0;i<26;i++){
            parent[i] = i;
        }
        for(String s:equations){
            if(s.charAt(1)=='='){
                union(parent,s.charAt(0)-'a',s.charAt(3)-'a');
            }
        }
        for(String s:equations){
            if(s.charAt(1)=='!'){
                if(find(parent,s.charAt(0)-'a')==find(parent,s.charAt(3)-'a')){
                    return false;
                }
            }
        }
        return true;
    }
    private int find(int[] parent,int i){
        if(parent[i]!=i){
            parent[i] = find(parent,parent[i]);
        }
        return parent[i];
    }
}