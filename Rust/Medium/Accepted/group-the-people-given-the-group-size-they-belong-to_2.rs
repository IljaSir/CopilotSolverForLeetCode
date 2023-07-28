impl Solution {
    pub fn group_the_people(group_sizes: Vec<i32>) -> Vec<Vec<i32>> {
        
        let mut res = vec![];
        let mut map = std::collections::HashMap::new();
        for (i, &size) in group_sizes.iter().enumerate() {
            let v = map.entry(size).or_insert(vec![]);
            v.push(i as i32);
            if v.len() == size as usize {
                res.push(v.clone());
                v.clear();
            }
        }
        res
    }
}