impl Solution {
    pub fn is_perfect_square(num: i32) -> bool {
        
        let mut n = 1;
        while n * n <= num {
            if n * n == num {
                return true;
            }
            n += 1;
        }
        false
    }
}