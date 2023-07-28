impl Solution {
    pub fn sort_people(names: Vec<String>, heights: Vec<i32>) -> Vec<String> {
        
        let mut sorted: Vec<(i32, String)> = heights.iter().zip(names.iter().map(|s| s.to_string())).collect();
        sorted.sort_by(|a, b| b.0.cmp(&a.0));
        sorted.iter().map(|s| s.1.to_owned()).collect()
    }
}