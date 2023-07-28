impl Solution {
    pub fn sort_people(names: Vec<String>, heights: Vec<i32>) -> Vec<String> {
        
        let mut v: Vec<_> = names.iter().zip(heights.iter()).collect();
        v.sort_by(|a, b| b.1.cmp(a.1));
        v.iter().map(|x| x.0.to_string()).collect()
    }
}