impl Solution {
    pub fn sort_people(names: Vec<String>, heights: Vec<i32>) -> Vec<String> {
        
        let mut result = names.clone();
        let mut sorted_heights = heights.clone();
        sorted_heights.sort();
        sorted_heights.reverse();
        for i in 0..sorted_heights.len() {
            let index = heights.iter().position(|&x| x == sorted_heights[i]).unwrap();
            result[i] = names[index].clone();
        }
        result
    }
}