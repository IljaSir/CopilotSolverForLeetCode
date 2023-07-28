impl Solution {
    pub fn convert_time(current: String, correct: String) -> i32 {
        
        let mut current = current.split(":").map(|s| s.parse::<i32>().unwrap()).collect::<Vec<_>>();
        let correct = correct.split(":").map(|s| s.parse::<i32>().unwrap()).collect::<Vec<_>>();
        let mut ans = 0;
        let mut carry = 0;
        let mut i = 1;
        while i >= 0 {
            let mut diff = correct[i] - current[i] + carry;
            if diff < 0 {
                diff += 60;
                carry = -1;
            } else {
                carry = 0;
            }
            if diff >= 60 {
                diff -= 60;
                carry += 1;
            }
            if diff >= 15 {
                diff -= 15;
                carry += 1;
            }
            if diff >= 5 {
                diff -= 5;
                carry += 1;
            }
            if diff >= 1 {
                diff -= 1;
                carry += 1;
            }
            ans += diff;
            i -= 1;
        }
        ans
    }
}