impl Solution {
    pub fn group_the_people(group_sizes: Vec<i32>) -> Vec<Vec<i32>> {
        
        let mut ret = Vec::new();
        let mut map = std::collections::HashMap::new();
        for (i, size) in group_sizes.iter().enumerate() {
            let size = *size;
            let group = map.entry(size).or_insert(Vec::new());
            group.push(i as i32);
            if group.len() == size as usize {
                ret.push(std::mem::take(group));
            }
        }
        ret
    }
}