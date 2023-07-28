impl Solution {
    pub fn dest_city(paths: Vec<Vec<String>>) -> String {
        
        let mut map = std::collections::HashMap::new();
        for path in paths {
            map.insert(path[0].clone(), path[1].clone());
        }
        let mut city = map.get("JFK").unwrap().clone();
        while map.contains_key(&city) {
            city = map.get(&city).unwrap().clone();
        }
        city
    }
}