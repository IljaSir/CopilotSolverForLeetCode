impl Solution {
    pub fn rotated_digits(n: i32) -> i32 {
        
        let mut result = 0;
        for i in 1..=n {
            let mut j = i;
            let mut valid = false;
            while j > 0 {
                let d = j % 10;
                if d == 3 || d == 4 || d == 7 {
                    valid = false;
                    break;
                }
                if d == 2 || d == 5 || d == 6 || d == 9 {
                    valid = true;
                }
                j /= 10;
            }
            if valid {
                result += 1;
            }
        }
        result
    }
}