impl Solution {
    pub fn group_the_people(group_sizes: Vec<i32>) -> Vec<Vec<i32>> {
        
        let mut res = Vec::new();
        let mut map = std::collections::HashMap::new();
        for (i, size) in group_sizes.iter().enumerate() {
            map.entry(size).or_insert(Vec::new()).push(i as i32);
        }
        for (size, group) in map {
            let mut i = 0;
            while i < group.len() {
                res.push(group[i..(i+size as usize)].to_vec());
                i += size as usize;
            }
        }
        res
    }
}