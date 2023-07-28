impl Solution {
    pub fn is_perfect_square(num: i32) -> bool {
        
        let mut x = num;
        while x * x > num {
            x = (x + num / x) / 2;
        }
        x * x == num
    }
}