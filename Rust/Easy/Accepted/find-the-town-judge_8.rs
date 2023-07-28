impl Solution {
    pub fn find_judge(n: i32, trust: Vec<Vec<i32>>) -> i32 {
        
        let mut in_degree = vec![0; n as usize];
        let mut out_degree = vec![0; n as usize];
        for edge in trust {
            out_degree[(edge[0] - 1) as usize] += 1;
            in_degree[(edge[1] - 1) as usize] += 1;
        }
        for i in 0..n as usize {
            if in_degree[i] == n - 1 && out_degree[i] == 0 {
                return (i + 1) as i32;
            }
        }
        -1
    }
}