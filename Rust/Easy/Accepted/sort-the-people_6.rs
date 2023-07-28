impl Solution {
    pub fn sort_people(names: Vec<String>, heights: Vec<i32>) -> Vec<String> {
        
        let mut names_heights = names.iter().zip(heights.iter()).collect::<Vec<_>>();
        names_heights.sort_by_key(|&(_, &height)| height);
        names_heights.reverse();
        names_heights.into_iter().map(|(name, _)| name.to_string()).collect()
    }
}