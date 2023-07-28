impl Solution {
    pub fn dest_city(paths: Vec<Vec<String>>) -> String {
        
        paths.iter().fold(String::new(), |acc, x| {
            if !paths.iter().any(|y| y[0] == x[1]) {
                return x[1].clone();
            }
            acc
        })
    }
}