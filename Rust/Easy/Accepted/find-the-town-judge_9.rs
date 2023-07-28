impl Solution {
    pub fn find_judge(n: i32, trust: Vec<Vec<i32>>) -> i32 {
        
        if n == 1 {
            return 1;
        }
        let mut trust_map = vec![0; n as usize];
        for t in trust {
            trust_map[t[0] as usize - 1] -= 1;
            trust_map[t[1] as usize - 1] += 1;
        }
        for i in 0..n as usize {
            if trust_map[i] == n - 1 {
                return (i + 1) as i32;
            }
        }
        -1
    }
}