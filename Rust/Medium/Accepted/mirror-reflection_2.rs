impl Solution {
    pub fn mirror_reflection(p: i32, q: i32) -> i32 {
        
        let mut m = p;
        let mut n = q;
        while m % 2 == 0 && n % 2 == 0 {
            m /= 2;
            n /= 2;
        }
        if m % 2 == 0 {
            2
        } else if n % 2 == 0 {
            0
        } else {
            1
        }
    }
}