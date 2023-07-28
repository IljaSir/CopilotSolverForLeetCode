impl Solution {
    pub fn find_judge(n: i32, trust: Vec<Vec<i32>>) -> i32 {
        
        let mut trust_count = vec![0; n as usize];
        for t in trust.iter() {
            trust_count[(t[0] - 1) as usize] -= 1;
            trust_count[(t[1] - 1) as usize] += 1;
        }
        for (i, c) in trust_count.iter().enumerate() {
            if *c == n - 1 {
                return (i + 1) as i32;
            }
        }
        -1
    }
}