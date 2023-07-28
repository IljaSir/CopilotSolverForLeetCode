impl Solution {
    pub fn maximum_population(logs: Vec<Vec<i32>>) -> i32 {
        
        let mut year = vec![0; 101];
        for log in logs {
            year[log[0] as usize - 1950] += 1;
            year[log[1] as usize - 1950] -= 1;
        }
        let mut max = 0;
        let mut sum = 0;
        let mut ans = 1950;
        for i in 0..101 {
            sum += year[i];
            if sum > max {
                max = sum;
                ans = 1950 + i;
            }
        }
        ans
    }
}