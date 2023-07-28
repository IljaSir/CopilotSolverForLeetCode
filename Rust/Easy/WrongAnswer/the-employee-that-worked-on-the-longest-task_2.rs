impl Solution {
    pub fn hardest_worker(n: i32, logs: Vec<Vec<i32>>) -> i32 {
        
        let mut tasks = vec![0; n as usize];
        for i in 0..logs.len() {
            if i == 0 {
                tasks[logs[i][0] as usize] += logs[i][1];
            } else {
                tasks[logs[i][0] as usize] += logs[i][1] - logs[i-1][1];
            }
        }
        let mut max = 0;
        let mut id = 0;
        for i in 0..tasks.len() {
            if tasks[i] > max {
                max = tasks[i];
                id = i as i32;
            }
        }
        id
    }
}