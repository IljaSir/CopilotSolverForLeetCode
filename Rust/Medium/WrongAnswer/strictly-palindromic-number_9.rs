impl Solution {
    pub fn is_strictly_palindromic(n: i32) -> bool {
        
        let mut x = n;
        let mut y = n;
        let mut z = 0;
        while x > 0 {
            z += x % 10;
            x /= 10;
            if x > 0 {
                z *= 10;
            }
        }
        if z != n {
            return false;
        }
        for i in 2..n {
            let mut x = n;
            let mut y = 0;
            while x > 0 {
                y += x % i;
                x /= i;
                if x > 0 {
                    y *= i;
                }
            }
            let mut x = y;
            let mut z = 0;
            while x > 0 {
                z += x % 10;
                x /= 10;
                if x > 0 {
                    z *= 10;
                }
            }
            if z != y {
                return false;
            }
        }
        true
    }
}