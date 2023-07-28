class Solution {
    public int eatenApples(int[] apples, int[] days) {
        
        int n = apples.length;
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0; i < n; i++){
            if(apples[i] > 0){
                pq.add(i + days[i] - 1);
            }
            while(!pq.isEmpty() && pq.peek() < i){
                pq.poll();
            }
            if(!pq.isEmpty()){
                result++;
                if(apples[pq.peek() - days[pq.peek()]] > 1){
                    apples[pq.peek() - days[pq.peek()]]--;
                }else{
                    apples[pq.peek() - days[pq.peek()]] = 0;
                    days[pq.peek()] = 0;
                }
                pq.poll();
            }
        }
        int i = n;
        while(!pq.isEmpty()){
            while(!pq.isEmpty() && pq.peek() < i){
                pq.poll();
            }
            if(!pq.isEmpty()){
                result++;
                if(apples[pq.peek() - days[pq.peek()]] > 1){
                    apples[pq.peek() - days[pq.peek()]]--;
                }else{
                    apples[pq.peek() - days[pq.peek()]] = 0;
                    days[pq.peek()] = 0;
                }
                pq.poll();
            }
            i++;
        }
        return result;
    }
}