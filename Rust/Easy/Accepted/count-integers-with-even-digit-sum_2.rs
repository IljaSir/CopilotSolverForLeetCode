impl Solution {
    pub fn count_even(num: i32) -> i32 {
        
        let mut sum = 0;
        for i in 1..=num {
            if i.to_string().chars().map(|c| c.to_digit(10).unwrap()).sum::<u32>() % 2 == 0 {
                sum += 1;
            }
        }
        sum
    }
}