impl Solution {
    pub fn sort_people(names: Vec<String>, heights: Vec<i32>) -> Vec<String> {
        
        let mut names = names;
        let mut heights = heights;
        let mut res = vec![];
        for i in 0..heights.len() {
            for j in i..heights.len() {
                if heights[i] < heights[j] {
                    heights.swap(i, j);
                    names.swap(i, j);
                }
            }
        }
        for i in 0..heights.len() {
            res.push(names[i].clone());
        }
        res
    }
}