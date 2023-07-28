impl Solution {
    pub fn hardest_worker(n: i32, logs: Vec<Vec<i32>>) -> i32 {
        
        let mut res = vec![0; n as usize];
        for i in 1..logs.len() {
            let t = logs[i][1] - logs[i-1][1];
            res[logs[i][0] as usize] += t;
        }
        res.iter().enumerate().max_by_key(|(_, v)| *v).unwrap().0 as i32
    }
}