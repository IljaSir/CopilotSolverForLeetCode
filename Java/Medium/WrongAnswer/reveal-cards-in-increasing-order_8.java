class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        
        int[] result = new int[deck.length];
        Arrays.sort(deck);
        int index = 0;
        for(int i = 0; i < deck.length; i++){
            if(i % 2 == 0){
                result[index] = deck[i];
                index++;
            }else{
                result[deck.length - i/2 - 1] = deck[i];
            }
        }
        return result;
    }
}