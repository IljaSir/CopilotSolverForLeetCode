impl Solution {
    pub fn rotated_digits(n: i32) -> i32 {
        
        let mut count = 0;
        for i in 1..=n {
            let mut is_good = false;
            let mut j = i;
            while j > 0 {
                let digit = j % 10;
                if digit == 3 || digit == 4 || digit == 7 {
                    is_good = false;
                    break;
                }
                if digit == 2 || digit == 5 || digit == 6 || digit == 9 {
                    is_good = true;
                }
                j /= 10;
            }
            if is_good {
                count += 1;
            }
        }
        count
    }
}