impl Solution {
    pub fn sort_people(names: Vec<String>, heights: Vec<i32>) -> Vec<String> {
        
        let mut names: Vec<_> = names.into_iter().map(|n| n.as_str()).collect();
        let mut heights = heights;
        let mut idx = (0..names.len()).collect::<Vec<_>>();
        idx.sort_by_key(|&i| (heights[i], names[i]));
        idx.reverse();
        idx.into_iter().map(|i| names[i].to_string()).collect()
    }
}