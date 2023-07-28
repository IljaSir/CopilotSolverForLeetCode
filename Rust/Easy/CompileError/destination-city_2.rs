impl Solution {
    pub fn dest_city(paths: Vec<Vec<String>>) -> String {
        
        let mut cities = Vec::new();
        for path in paths {
            cities.push(path[0].clone());
        }
        for path in paths {
            if !cities.contains(&path[1]) {
                return path[1].clone();
            }
        }
        String::new()
    }
}