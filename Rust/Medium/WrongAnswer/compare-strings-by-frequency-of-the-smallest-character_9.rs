impl Solution {
    pub fn num_smaller_by_frequency(queries: Vec<String>, words: Vec<String>) -> Vec<i32> {
        
        let mut words = words.iter().map(|x| x.chars().fold(vec![0;26], |mut acc, c| { acc[c as usize - 97] += 1; acc })).collect::<Vec<Vec<i32>>>();
        let mut queries = queries.iter().map(|x| x.chars().fold(vec![0;26], |mut acc, c| { acc[c as usize - 97] += 1; acc })).collect::<Vec<Vec<i32>>>();
        for i in 0..words.len() {
            for j in 1..26 {
                words[i][j] += words[i][j-1];
            }
        }
        for i in 0..queries.len() {
            for j in 1..26 {
                queries[i][j] += queries[i][j-1];
            }
        }
        queries.iter().map(|x| words.iter().filter(|y| x[0] < y[0]).count() as i32).collect()
    }
}