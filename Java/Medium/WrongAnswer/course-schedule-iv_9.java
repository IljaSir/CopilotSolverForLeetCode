class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        List<Boolean> result = new ArrayList<Boolean>();
        for (int i = 0; i < queries.length; i++) {
            result.add(false);
        }
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (map.containsKey(prerequisites[i][0])) {
                map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            } else {
                Set<Integer> set = new HashSet<Integer>();
                set.add(prerequisites[i][1]);
                map.put(prerequisites[i][0], set);
            }
        }
        for (int i = 0; i < queries.length; i++) {
            if (map.containsKey(queries[i][0])) {
                if (map.get(queries[i][0]).contains(queries[i][1])) {
                    result.set(i, true);
                } else {
                    for (Integer key : map.get(queries[i][0])) {
                        if (map.containsKey(key)) {
                            if (map.get(key).contains(queries[i][1])) {
                                result.set(i, true);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}