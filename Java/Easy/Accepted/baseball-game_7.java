class Solution {
    public int calPoints(String[] operations) {
        
        int sum = 0;
        int[] arr = new int[operations.length];
        int j = 0;
        for(int i = 0; i < operations.length; i++){
            if(operations[i].equals("+")){
                arr[j] = arr[j-1] + arr[j-2];
                sum += arr[j];
                j++;
            }
            else if(operations[i].equals("D")){
                arr[j] = 2*arr[j-1];
                sum += arr[j];
                j++;
            }
            else if(operations[i].equals("C")){
                sum -= arr[j-1];
                j--;
            }
            else{
                arr[j] = Integer.parseInt(operations[i]);
                sum += arr[j];
                j++;
            }
        }
        return sum;
    }
}