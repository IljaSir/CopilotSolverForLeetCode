impl Solution {
    pub fn count_even(num: i32) -> i32 {
        
        let mut result = 0;
        for i in 1..=num {
            if i.to_string().chars().map(|x| x.to_digit(10).unwrap()).sum::<u32>() % 2 == 0 {
                result += 1;
            }
        }
        result
    }
}