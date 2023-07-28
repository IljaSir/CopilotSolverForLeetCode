impl Solution {
    pub fn sort_people(names: Vec<String>, heights: Vec<i32>) -> Vec<String> {
        
        let mut names = names;
        let mut heights = heights;
        let mut res = vec![];
        let mut i = 0;
        while i < heights.len() {
            let mut j = i + 1;
            while j < heights.len() {
                if heights[i] < heights[j] {
                    heights.swap(i, j);
                    names.swap(i, j);
                }
                j += 1;
            }
            i += 1;
        }
        i = 0;
        while i < heights.len() {
            let mut j = i + 1;
            while j < heights.len() {
                if heights[i] == heights[j] {
                    if names[i] > names[j] {
                        names.swap(i, j);
                    }
                }
                j += 1;
            }
            i += 1;
        }
        i = 0;
        while i < heights.len() {
            res.push(names[i].clone());
            i += 1;
        }
        res
    }
}