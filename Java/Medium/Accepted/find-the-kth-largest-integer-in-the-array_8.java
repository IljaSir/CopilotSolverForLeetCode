class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        
        PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>(){
            public int compare(String s1, String s2){
                if(s1.length() == s2.length()){
                    return s1.compareTo(s2);
                }else{
                    return s1.length() - s2.length();
                }
            }
        });
        for(String s: nums){
            pq.add(s);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.poll();
    }
}