impl Solution {
    pub fn check_perfect_number(num: i32) -> bool {
        
        let mut sum = 0;
        for i in 1..=num/2 {
            if num % i == 0 {
                sum += i;
            }
        }
        sum == num
    }
}