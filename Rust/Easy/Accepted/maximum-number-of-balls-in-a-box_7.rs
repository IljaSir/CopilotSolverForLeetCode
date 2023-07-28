impl Solution {
    pub fn count_balls(low_limit: i32, high_limit: i32) -> i32 {
        
        let mut boxes = vec![0; 46];
        for n in low_limit..=high_limit {
            let mut sum = 0;
            let mut n = n;
            while n > 0 {
                sum += n % 10;
                n /= 10;
            }
            boxes[sum as usize] += 1;
        }
        boxes.into_iter().max().unwrap()
    }
}