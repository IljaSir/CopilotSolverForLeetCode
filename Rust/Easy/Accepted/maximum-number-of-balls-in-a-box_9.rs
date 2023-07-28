impl Solution {
    pub fn count_balls(low_limit: i32, high_limit: i32) -> i32 {
        
        let mut ball_count = vec![0;46];
        for i in low_limit..high_limit+1{
            let mut sum = 0;
            let mut j = i;
            while j > 0{
                sum += j % 10;
                j /= 10;
            }
            ball_count[sum as usize] += 1;
        }
        ball_count.into_iter().max().unwrap()
    }
}