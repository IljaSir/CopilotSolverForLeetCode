impl Solution {
    pub fn dest_city(paths: Vec<Vec<String>>) -> String {
        
        let mut set = std::collections::HashSet::new();
        for path in &paths {
            set.insert(&path[0]);
        }
        for path in &paths {
            if !set.contains(&path[1]) {
                return path[1].clone();
            }
        }
        String::new()
    }
}