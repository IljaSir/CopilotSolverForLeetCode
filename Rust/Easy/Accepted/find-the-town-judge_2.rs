impl Solution {
    pub fn find_judge(n: i32, trust: Vec<Vec<i32>>) -> i32 {
        
        let mut judge = vec![0; n as usize + 1];
        for t in trust {
            judge[t[0] as usize] -= 1;
            judge[t[1] as usize] += 1;
        }
        for i in 1..=n {
            if judge[i as usize] == n - 1 {
                return i;
            }
        }
        -1
    }
}