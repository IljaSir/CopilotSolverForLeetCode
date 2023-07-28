impl Solution {
    pub fn most_visited(n: i32, rounds: Vec<i32>) -> Vec<i32> {
        
        let mut visited = vec![0; n as usize];
        let mut max = 0;
        for i in 1..rounds.len() {
            let (start, end) = (rounds[i-1], rounds[i]);
            if start < end {
                for j in start..end {
                    visited[j as usize - 1] += 1;
                    max = max.max(visited[j as usize - 1]);
                }
            } else {
                for j in start..=n {
                    visited[j as usize - 1] += 1;
                    max = max.max(visited[j as usize - 1]);
                }
                for j in 1..=end {
                    visited[j as usize - 1] += 1;
                    max = max.max(visited[j as usize - 1]);
                }
            }
        }
        let mut ans = vec![];
        for i in 0..n {
            if visited[i as usize] == max {
                ans.push(i+1);
            }
        }
        ans
    }
}