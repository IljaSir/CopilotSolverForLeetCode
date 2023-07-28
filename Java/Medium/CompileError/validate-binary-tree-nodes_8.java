class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for(int i=0;i<n;i++){
            if(leftChild[i]!=-1){
                if(parent[leftChild[i]]!=-1) return false;
                parent[leftChild[i]] = i;
            }
            if(rightChild[i]!=-1){
                if(parent[rightChild[i]]!=-1) return false;
                parent[rightChild[i]] = i;
            }
        }
        int root = -1;
        for(int i=0;i<n;i++){
            if(parent[i]==-1){
                if(root!=-1) return false;
                root = i;
            }
        }
        if(root==-1) return false;
        int[] count = new int[n];
        dfs(root, leftChild, rightChild, count);
        for(int i=0;i<n;i++){
            if(count[i]==0) return false;
        }
        return true;
    }
}