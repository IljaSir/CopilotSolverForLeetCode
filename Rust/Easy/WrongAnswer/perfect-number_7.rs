impl Solution {
    pub fn check_perfect_number(num: i32) -> bool {
        
        let mut sum = 0;
        for i in 1..(num as f64).sqrt() as i32 {
            if num % i == 0 {
                sum += i;
                if i != 1 && i != num / i {
                    sum += num / i;
                }
            }
        }
        sum == num
    }
}