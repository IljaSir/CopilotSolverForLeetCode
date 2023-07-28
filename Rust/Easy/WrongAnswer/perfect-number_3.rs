impl Solution {
    pub fn check_perfect_number(num: i32) -> bool {
        
        let mut sum = 1;
        let mut i = 2;
        while i * i <= num {
            if num % i == 0 {
                sum += i;
                sum += num / i;
            }
            i += 1;
        }
        sum == num
    }
}