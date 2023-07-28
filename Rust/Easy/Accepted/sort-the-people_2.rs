impl Solution {
    pub fn sort_people(names: Vec<String>, heights: Vec<i32>) -> Vec<String> {
        
        let mut names_heights = names
            .into_iter()
            .zip(heights)
            .collect::<Vec<(String, i32)>>();
        
        names_heights.sort_by(|a, b| {
            if a.1 == b.1 {
                a.0.cmp(&b.0)
            } else {
                b.1.cmp(&a.1)
            }
        });
        
        names_heights.into_iter().map(|x| x.0).collect::<Vec<String>>()
    }
}