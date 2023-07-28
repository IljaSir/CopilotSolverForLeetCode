impl Solution {
    pub fn is_perfect_square(num: i32) -> bool {
        
        let mut i = 1;
        let mut n = num;
        while n > 0 {
            n -= i;
            i += 2;
        }
        n == 0
    }
}