impl Solution {
    pub fn group_the_people(group_sizes: Vec<i32>) -> Vec<Vec<i32>> {
        
        let mut map: std::collections::HashMap<i32, Vec<i32>> = std::collections::HashMap::new();
        for (i, size) in group_sizes.iter().enumerate() {
            map.entry(*size).or_insert_with(|| Vec::new()).push(i as i32);
        }
        let mut ret: Vec<Vec<i32>> = Vec::new();
        for (size, mut group) in map.into_iter() {
            while !group.is_empty() {
                ret.push(group.drain(0..size as usize).collect());
            }
        }
        ret
    }
}