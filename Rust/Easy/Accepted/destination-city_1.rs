impl Solution {
    pub fn dest_city(paths: Vec<Vec<String>>) -> String {
        
        let mut start = Vec::new();
        let mut end = Vec::new();
        for p in paths {
            start.push(p[0].clone());
            end.push(p[1].clone());
        }
        for e in end {
            if !start.contains(&e) {
                return e;
            }
        }
        String::from("")
    }
}