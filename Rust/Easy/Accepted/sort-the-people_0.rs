impl Solution {
    pub fn sort_people(names: Vec<String>, heights: Vec<i32>) -> Vec<String> {
        
        let mut v = Vec::new();
        for i in 0..names.len() {
            v.push((names[i].clone(), heights[i]));
        }
        v.sort_by(|a, b| {
            if a.1 == b.1 {
                a.0.cmp(&b.0)
            } else {
                b.1.cmp(&a.1)
            }
        });
        v.iter().map(|x| x.0.clone()).collect()
    }
}