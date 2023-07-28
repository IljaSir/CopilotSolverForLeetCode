impl Solution {
    pub fn rotated_digits(n: i32) -> i32 {
        
        let mut counter = 0;
        for i in 1..=n {
            let mut c = i;
            let mut valid = false;
            while c > 0 {
                let digit = c % 10;
                if digit == 3 || digit == 4 || digit == 7 {
                    valid = false;
                    break;
                } else if digit == 2 || digit == 5 || digit == 6 || digit == 9 {
                    valid = true;
                }
                c /= 10;
            }
            if valid {
                counter += 1;
            }
        }
        counter
    }
}