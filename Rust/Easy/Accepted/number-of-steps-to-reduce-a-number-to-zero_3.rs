impl Solution {
    pub fn number_of_steps(num: i32) -> i32 {
        
        let mut n = num;
        let mut count = 0;
        while n > 0 {
            if n % 2 == 0 {
                n /= 2;
            } else {
                n -= 1;
            }
            count += 1;
        }
        count
    }
}