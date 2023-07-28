impl Solution {
    pub fn rotated_digits(n: i32) -> i32 {
        
        let mut count = 0;
        for i in 1..=n {
            let mut j = i;
            let mut good = false;
            while j > 0 {
                let digit = j % 10;
                if digit == 3 || digit == 4 || digit == 7 {
                    good = false;
                    break;
                }
                if digit == 2 || digit == 5 || digit == 6 || digit == 9 {
                    good = true;
                }
                j /= 10;
            }
            if good {
                count += 1;
            }
        }
        count
    }
}