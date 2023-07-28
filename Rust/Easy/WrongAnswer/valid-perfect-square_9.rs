impl Solution {
    pub fn is_perfect_square(num: i32) -> bool {
        
        let mut r = num;
        while r*r > num {
            r = (r + num/r)/2;
        }
        r*r == num
    }
}