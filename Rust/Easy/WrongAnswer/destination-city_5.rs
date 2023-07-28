impl Solution {
    pub fn dest_city(paths: Vec<Vec<String>>) -> String {
        
        let mut start = String::new();
        let mut end = String::new();
        for path in paths {
            if start.is_empty() {
                start = path[0].clone();
                end = path[1].clone();
            } else {
                if start == path[0] {
                    start = path[1].clone();
                } else if start == path[1] {
                    start = path[0].clone();
                } else if end == path[0] {
                    end = path[1].clone();
                } else if end == path[1] {
                    end = path[0].clone();
                }
            }
        }
        end
    }
}