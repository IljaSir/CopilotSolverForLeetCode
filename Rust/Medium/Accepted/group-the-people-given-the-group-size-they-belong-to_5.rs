impl Solution {
    pub fn group_the_people(group_sizes: Vec<i32>) -> Vec<Vec<i32>> {
        
        let mut result: Vec<Vec<i32>> = Vec::new();
        let mut group: Vec<Vec<i32>> = vec![Vec::new(); 501];
        for (i, size) in group_sizes.iter().enumerate() {
            group[*size as usize].push(i as i32);
            if group[*size as usize].len() == *size as usize {
                result.push(group[*size as usize].clone());
                group[*size as usize].clear();
            }
        }
        result
    }
}