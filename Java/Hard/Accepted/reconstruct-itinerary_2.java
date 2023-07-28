class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }
        List<String> result = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();
        stack.push("JFK");
        while (!stack.isEmpty()) {
            while (graph.containsKey(stack.peek()) && !graph.get(stack.peek()).isEmpty()) {
                stack.push(graph.get(stack.peek()).poll());
            }
            result.add(0, stack.pop());
        }
        return result;
    }
}