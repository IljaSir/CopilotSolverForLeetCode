class Solution {
    public int calPoints(String[] operations) {
        
        int[] score = new int[operations.length];
        int index = 0;
        for(int i=0; i<operations.length; i++){
            if(operations[i].equals("C")){
                index--;
                score[index] = 0;
            }else if(operations[i].equals("D")){
                score[index] = score[index-1]*2;
                index++;
            }else if(operations[i].equals("+")){
                score[index] = score[index-1]+score[index-2];
                index++;
            }else{
                score[index] = Integer.parseInt(operations[i]);
                index++;
            }
        }
        int result = 0;
        for(int i=0; i<score.length; i++){
            result += score[i];
        }
        return result;
    }
}