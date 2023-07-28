impl Solution {
    pub fn maximum_population(logs: Vec<Vec<i32>>) -> i32 {
        
        let mut v = vec![0; 101];
        for log in logs {
            v[(log[0] - 1950) as usize] += 1;
            v[(log[1] - 1950) as usize] -= 1;
        }
        let mut max = 0;
        let mut res = 0;
        let mut cur = 0;
        for i in 0..v.len() {
            cur += v[i];
            if cur > max {
                max = cur;
                res = i;
            }
        }
        res as i32 + 1950
    }
}