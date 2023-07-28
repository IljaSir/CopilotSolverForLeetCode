impl Solution {
    pub fn hardest_worker(n: i32, logs: Vec<Vec<i32>>) -> i32 {
        
        let mut res = vec![0; n as usize];
        for i in 0..logs.len() {
            if i == 0 {
                res[logs[i][0] as usize] += logs[i][1];
            } else {
                res[logs[i][0] as usize] += logs[i][1] - logs[i - 1][1];
            }
        }
        let mut max = 0;
        let mut id = 0;
        for i in 0..res.len() {
            if res[i] > max {
                max = res[i];
                id = i;
            }
        }
        id as i32
    }
}