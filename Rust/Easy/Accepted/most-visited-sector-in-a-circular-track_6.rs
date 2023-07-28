impl Solution {
    pub fn most_visited(n: i32, rounds: Vec<i32>) -> Vec<i32> {
        
        let mut visited = vec![0; n as usize];
        let mut i = rounds[0];
        let mut j = 0;
        while i != rounds[rounds.len() - 1] {
            visited[(i - 1) as usize] += 1;
            i += 1;
            if i > n {
                i = 1;
            }
        }
        visited[(i - 1) as usize] += 1;
        let mut max = 0;
        let mut result = vec![];
        for i in 0..n {
            if visited[i as usize] > max {
                max = visited[i as usize];
                result = vec![i + 1];
            } else if visited[i as usize] == max {
                result.push(i + 1);
            }
        }
        result
    }
}