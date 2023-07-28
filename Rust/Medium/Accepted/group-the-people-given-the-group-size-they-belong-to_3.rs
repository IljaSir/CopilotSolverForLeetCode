impl Solution {
    pub fn group_the_people(group_sizes: Vec<i32>) -> Vec<Vec<i32>> {
        
        let mut result: Vec<Vec<i32>> = vec![];
        let mut group: Vec<Vec<i32>> = vec![vec![]; 501];
        for i in 0..group_sizes.len() {
            group[group_sizes[i] as usize].push(i as i32);
        }
        for i in 1..group.len() {
            let mut j = 0;
            while j < group[i].len() {
                result.push(group[i][j..(j + i)].to_vec());
                j += i;
            }
        }
        result
    }
}