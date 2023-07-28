impl Solution {
    pub fn maximum_score(a: i32, b: i32, c: i32) -> i32 {
        
        let mut a = a;
        let mut b = b;
        let mut c = c;
        let mut sum = 0;
        while a > 0 && b > 0 && c > 0 {
            sum += 1;
            let max = std::cmp::max(a, std::cmp::max(b, c));
            if max == a {
                a -= 1;
                b -= 1;
            } else if max == b {
                b -= 1;
                c -= 1;
            } else {
                c -= 1;
                a -= 1;
            }
        }
        sum
    }
}