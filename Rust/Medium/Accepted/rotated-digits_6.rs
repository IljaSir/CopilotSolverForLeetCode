impl Solution {
    pub fn rotated_digits(n: i32) -> i32 {
        
        let mut ans = 0;
        for i in 1..=n {
            let mut flag = false;
            let mut j = i;
            while j > 0 {
                let d = j % 10;
                if d == 3 || d == 4 || d == 7 {
                    flag = false;
                    break;
                } else if d == 2 || d == 5 || d == 6 || d == 9 {
                    flag = true;
                }
                j /= 10;
            }
            if flag {
                ans += 1;
            }
        }
        ans
    }
}