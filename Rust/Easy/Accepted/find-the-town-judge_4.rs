impl Solution {
    pub fn find_judge(n: i32, trust: Vec<Vec<i32>>) -> i32 {
        
        let mut count: Vec<i32> = vec![0; n as usize];
        for t in trust {
            count[(t[0] - 1) as usize] -= 1;
            count[(t[1] - 1) as usize] += 1;
        }
        for i in 0..n as usize {
            if count[i] == n - 1 {
                return (i + 1) as i32;
            }
        }
        -1
    }
}