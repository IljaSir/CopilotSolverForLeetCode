impl Solution {
    pub fn check_if_prerequisite(num_courses: i32, prerequisites: Vec<Vec<i32>>, queries: Vec<Vec<i32>>) -> Vec<bool> {
        
        let mut graph = vec![vec![]; num_courses as usize];
        let mut dp = vec![vec![false; num_courses as usize]; num_courses as usize];
        for (i, j) in prerequisites {
            graph[i as usize].push(j as usize);
        }
        for i in 0..num_courses as usize {
            let mut queue = vec![i];
            while let Some(j) = queue.pop() {
                for &k in &graph[j] {
                    if !dp[i][k] {
                        dp[i][k] = true;
                        queue.push(k);
                    }
                }
            }
        }
        queries.iter().map(|q| dp[q[0] as usize][q[1] as usize]).collect()
    }
}