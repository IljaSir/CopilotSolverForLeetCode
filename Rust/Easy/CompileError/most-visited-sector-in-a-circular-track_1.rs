impl Solution {
    pub fn most_visited(n: i32, rounds: Vec<i32>) -> Vec<i32> {
        
        let mut visited = vec![0; n as usize];
        let mut start = rounds[0] - 1;
        for i in 1..rounds.len() {
            let end = rounds[i] - 1;
            if start > end {
                for j in start..n as usize {
                    visited[j] += 1;
                }
                for j in 0..=end {
                    visited[j] += 1;
                }
            } else {
                for j in start..=end {
                    visited[j] += 1;
                }
            }
            start = end;
        }
        let max = visited.iter().max().unwrap();
        visited.iter().enumerate().filter(|&(_, &v)| v == *max).map(|(i, _)| (i + 1) as i32).collect()
    }
}