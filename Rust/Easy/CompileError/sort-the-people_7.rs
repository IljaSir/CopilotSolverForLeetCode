impl Solution {
    pub fn sort_people(names: Vec<String>, heights: Vec<i32>) -> Vec<String> {
        
        let mut names = names;
        let mut heights = heights;
        let mut heights_names = vec![];
        for i in 0..heights.len() {
            heights_names.push((heights[i], names[i].clone()));
        }
        heights_names.sort_unstable_by(|a, b| b.cmp(&a));
        let mut result = vec![];
        for i in 0..heights.len() {
            result.push(heights_names[i].1);
        }
        result
    }
}