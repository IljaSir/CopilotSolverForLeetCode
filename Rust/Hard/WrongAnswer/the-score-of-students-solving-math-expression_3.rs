impl Solution {
    pub fn score_of_students(s: String, answers: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut exp = 0;
        let mut mul = 1;
        for c in s.chars() {
            if c == '+' {
                exp += mul;
                mul = 1;
            } else if c == '*' {
                mul *= 2;
            } else {
                exp += mul * (c as i32 - '0' as i32);
            }
        }
        for &a in &answers {
            if a == exp {
                ans += 5;
            } else if a < exp {
                let mut flag = false;
                let mut exp2 = 0;
                let mut mul2 = 1;
                for c in s.chars() {
                    if c == '+' {
                        exp2 += mul2;
                        mul2 = 1;
                    } else if c == '*' {
                        mul2 *= 2;
                    } else {
                        exp2 += mul2 * (c as i32 - '0' as i32);
                        if exp2 == a {
                            flag = true;
                            break;
                        }
                    }
                }
                if flag {
                    ans += 2;
                }
            }
        }
        ans
    }
}