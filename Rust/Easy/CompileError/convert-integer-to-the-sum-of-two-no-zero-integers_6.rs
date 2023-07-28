impl Solution {
    pub fn get_no_zero_integers(n: i32) -> Vec<i32> {
        
        let mut a = 1;
        let mut b = n - 1;
        while contains_zero(a) || contains_zero(b) {
            a += 1;
            b -= 1;
        }
        vec![a, b]
    }
}