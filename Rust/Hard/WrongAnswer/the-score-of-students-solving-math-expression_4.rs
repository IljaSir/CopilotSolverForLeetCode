impl Solution {
    pub fn score_of_students(s: String, answers: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut n = 0;
        let mut op = '+';
        let mut nums = Vec::new();
        for c in s.chars() {
            if c == '+' || c == '*' {
                op = c;
            } else {
                let x = c as i32 - '0' as i32;
                if op == '+' {
                    n += x;
                } else {
                    n *= x;
                }
                if c == '*' {
                    nums.push(n);
                    n = 0;
                }
            }
        }
        nums.push(n);
        let mut n = 0;
        let mut op = '+';
        let mut nums2 = Vec::new();
        for c in s.chars() {
            if c == '+' || c == '*' {
                op = c;
            } else {
                let x = c as i32 - '0' as i32;
                if op == '+' {
                    n += x;
                } else {
                    n *= x;
                }
                if c == '*' {
                    nums2.push(n);
                    n = 0;
                }
            }
        }
        nums2.push(n);
        let mut res = 0;
        for x in nums2 {
            res += x;
        }
        for x in answers {
            if x == res {
                ans += 5;
            } else {
                let mut ok = true;
                for i in 0..nums.len() {
                    if nums[i] != x {
                        ok = false;
                    }
                }
                if ok {
                    ans += 2;
                }
            }
        }
        ans
    }
}