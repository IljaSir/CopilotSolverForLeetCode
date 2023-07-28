class Solution {
    public String destCity(List<List<String>> paths) {
        
        // Create a set of all the cities that are the start of a path.
        Set<String> startCities = new HashSet<>();
        for (List<String> path : paths) {
            startCities.add(path.get(0));
        }
        
        // Find the city that is not a start city.
        for (List<String> path : paths) {
            if (!startCities.contains(path.get(1))) {
                return path.get(1);
            }
        }
        
        return "";
    }
}