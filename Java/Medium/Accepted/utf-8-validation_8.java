class Solution {
    public boolean validUtf8(int[] data) {
        
        int n = data.length;
        for(int i=0; i<n; i++){
            int mask = 1 << 7;
            int count = 0;
            while((data[i] & mask) != 0){
                count++;
                mask = mask >> 1;
            }
            if(count == 0){
                continue;
            }
            if(count == 1 || count > 4){
                return false;
            }
            if(i+count > n){
                return false;
            }
            for(int j=i+1; j<i+count; j++){
                if((data[j] & (1 << 7)) == 0){
                    return false;
                }
                if((data[j] & (1 << 6)) != 0){
                    return false;
                }
            }
            i = i+count-1;
        }
        return true;
    }
}