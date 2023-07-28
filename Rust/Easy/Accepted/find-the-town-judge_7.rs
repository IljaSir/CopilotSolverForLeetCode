impl Solution {
    pub fn find_judge(n: i32, trust: Vec<Vec<i32>>) -> i32 {
        
        let mut trust_counts = vec![0; n as usize];
        for t in trust {
            trust_counts[(t[0] - 1) as usize] -= 1;
            trust_counts[(t[1] - 1) as usize] += 1;
        }
        for (i, c) in trust_counts.iter().enumerate() {
            if *c == n - 1 {
                return (i + 1) as i32;
            }
        }
        -1
    }
}