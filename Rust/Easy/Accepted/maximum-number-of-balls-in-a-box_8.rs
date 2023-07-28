impl Solution {
    pub fn count_balls(low_limit: i32, high_limit: i32) -> i32 {
        
        let mut boxs = vec![0; 46];
        for i in low_limit..=high_limit {
            let mut num = i;
            let mut sum = 0;
            while num > 0 {
                sum += num % 10;
                num /= 10;
            }
            boxs[sum as usize] += 1;
        }
        return *boxs.iter().max().unwrap();
    }
}