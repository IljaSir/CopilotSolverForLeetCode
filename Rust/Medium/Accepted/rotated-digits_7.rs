impl Solution {
    pub fn rotated_digits(n: i32) -> i32 {
        
        let mut cnt = 0;
        for i in 1..=n {
            let mut x = i;
            let mut valid = false;
            while x > 0 {
                let d = x % 10;
                if d == 3 || d == 4 || d == 7 {
                    valid = false;
                    break;
                }
                if d == 2 || d == 5 || d == 6 || d == 9 {
                    valid = true;
                }
                x /= 10;
            }
            if valid {
                cnt += 1;
            }
        }
        cnt
    }
}