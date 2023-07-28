impl Solution {
    pub fn rotated_digits(n: i32) -> i32 {
        
        let mut count = 0;
        for i in 1..=n {
            let mut valid = false;
            let mut x = i;
            while x > 0 {
                let digit = x % 10;
                if digit == 3 || digit == 4 || digit == 7 {
                    valid = false;
                    break;
                } else if digit == 2 || digit == 5 || digit == 6 || digit == 9 {
                    valid = true;
                }
                x /= 10;
            }
            if valid {
                count += 1;
            }
        }
        count
    }
}