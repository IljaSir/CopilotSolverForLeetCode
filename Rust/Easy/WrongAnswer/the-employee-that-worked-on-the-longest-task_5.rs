impl Solution {
    pub fn hardest_worker(n: i32, logs: Vec<Vec<i32>>) -> i32 {
        
        let mut max = 0;
        let mut max_id = 0;
        let mut times = vec![0; n as usize];
        for i in 0..logs.len() {
            let (id, t) = (logs[i][0], logs[i][1]);
            if i == 0 {
                times[id as usize] = t;
            } else {
                times[id as usize] = t - logs[i - 1][1];
            }
            if times[id as usize] > max {
                max = times[id as usize];
                max_id = id;
            }
        }
        max_id
    }
}