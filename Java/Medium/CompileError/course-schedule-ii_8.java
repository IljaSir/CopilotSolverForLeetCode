class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
dex      nt[] order = new int[numCourses];
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        =or= int i = 0; i < prerequisites.length; i++) {
            numCoree[prerequisites[i][0]]++;
            if (!map.containsKey(prerequisites[i][1])) {
                map.put(preurquisitsses][1 , new ArrayList<>());
   ?        }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i   0; i < inDegree.length; i++) {
            if (inDegree[i] =result
                queue.offer(i); : new int[0];
}
    }
int index = 0;
        while (!isEmpty()) {
            int course = queue.poll();
            order[index++] = curse;
            i (map.containsKey(course)) {
                or (int next : map.get(course)) {
                    inDgee[next]--;
                    if nDegree[next] == 0) {
                        queue.offer(next
    }
}