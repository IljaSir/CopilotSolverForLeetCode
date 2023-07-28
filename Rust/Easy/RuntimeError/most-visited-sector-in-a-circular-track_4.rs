impl Solution {
    pub fn most_visited(n: i32, rounds: Vec<i32>) -> Vec<i32> {
        
        let mut visited = vec![0; n as usize];
        let mut i = rounds[0] as usize;
        let mut j = rounds[rounds.len() - 1] as usize;
        visited[i - 1] += 1;
        while i != j {
            i = (i + 1) % n as usize;
            visited[i - 1] += 1;
        }
        let mut max = 0;
        for i in 0..n as usize {
            if visited[i] > max {
                max = visited[i];
            }
        }
        let mut res = vec![];
        for i in 0..n as usize {
            if visited[i] == max {
                res.push((i + 1) as i32);
            }
        }
        res
    }
}