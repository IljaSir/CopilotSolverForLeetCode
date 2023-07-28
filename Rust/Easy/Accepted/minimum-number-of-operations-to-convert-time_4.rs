impl Solution {
    pub fn convert_time(current: String, correct: String) -> i32 {
        
        let mut count = 0;
        let (mut h1, mut m1) = (0, 0);
        let (mut h2, mut m2) = (0, 0);
        for (i, c) in current.chars().enumerate() {
            if i < 2 {
                h1 = h1 * 10 + (c as i32 - '0' as i32);
            } else if i > 2 {
                m1 = m1 * 10 + (c as i32 - '0' as i32);
            }
        }
        for (i, c) in correct.chars().enumerate() {
            if i < 2 {
                h2 = h2 * 10 + (c as i32 - '0' as i32);
            } else if i > 2 {
                m2 = m2 * 10 + (c as i32 - '0' as i32);
            }
        }
        let mut total = h2 * 60 + m2 - (h1 * 60 + m1);
        while total > 0 {
            if total >= 60 {
                total -= 60;
            } else if total >= 15 {
                total -= 15;
            } else if total >= 5 {
                total -= 5;
            } else {
                total -= 1;
            }
            count += 1;
        }
        count
    }
}