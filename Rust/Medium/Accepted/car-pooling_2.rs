impl Solution {
    pub fn car_pooling(trips: Vec<Vec<i32>>, capacity: i32) -> bool {
        
        let mut dp = vec![0; 1001];
        for trip in trips {
            dp[trip[1] as usize] += trip[0];
            dp[trip[2] as usize] -= trip[0];
        }
        let mut sum = 0;
        for i in 0..1001 {
            sum += dp[i];
            if sum > capacity {
                return false;
            }
        }
        true
    }
}