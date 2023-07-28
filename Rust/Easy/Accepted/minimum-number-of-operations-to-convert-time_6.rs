impl Solution {
    pub fn convert_time(current: String, correct: String) -> i32 {
        
        let mut cur = 0;
        let mut cor = 0;
        for (i, c) in current.chars().enumerate() {
            if i == 0 {
                cur += (c as i32 - '0' as i32) * 600;
            } else if i == 1 {
                cur += (c as i32 - '0' as i32) * 60;
            } else if i == 3 {
                cur += (c as i32 - '0' as i32) * 10;
            } else {
                cur += (c as i32 - '0' as i32);
            }
        }
        for (i, c) in correct.chars().enumerate() {
            if i == 0 {
                cor += (c as i32 - '0' as i32) * 600;
            } else if i == 1 {
                cor += (c as i32 - '0' as i32) * 60;
            } else if i == 3 {
                cor += (c as i32 - '0' as i32) * 10;
            } else {
                cor += (c as i32 - '0' as i32);
            }
        }
        let mut ans = 0;
        let mut diff = cor - cur;
        if diff >= 60 {
            ans += diff / 60;
            diff -= (diff / 60) * 60;
        }
        if diff >= 15 {
            ans += diff / 15;
            diff -= (diff / 15) * 15;
        }
        if diff >= 5 {
            ans += diff / 5;
            diff -= (diff / 5) * 5;
        }
        ans + diff
    }
}