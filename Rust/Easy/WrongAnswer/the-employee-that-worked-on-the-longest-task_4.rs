impl Solution {
    pub fn hardest_worker(n: i32, logs: Vec<Vec<i32>>) -> i32 {
        
        let mut res = 0;
        let mut max = 0;
        for i in 0..n {
            let mut sum = 0;
            for j in 0..logs.len() {
                if logs[j][0] == i {
                    if j > 0 {
                        sum += logs[j][1] - logs[j - 1][1];
                    } else {
                        sum += logs[j][1];
                    }
                }
            }
            if sum > max {
                max = sum;
                res = i;
            }
        }
        res
    }
}