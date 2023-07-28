class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        
        int[] newCells = new int[cells.length];
        for(int i=0;i<n;i++){
            for(int j=0;j<cells.length;j++){
                if(j==0 || j==cells.length-1){
                    newCells[j]=0;
                }else{
                    if(cells[j-1]==cells[j+1]){
                        newCells[j]=1;
                    }else{
                        newCells[j]=0;
                    }
                }
            }
            cells = newCells;
            newCells = new int[cells.length];
        }
        return cells;
    }
}