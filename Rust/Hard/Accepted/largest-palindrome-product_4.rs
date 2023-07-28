impl Solution {
    pub fn largest_palindrome(n: i32) -> i32 {
        
        if n == 1 {
            return 9;
        }
        let upper = (10 as i64).pow(n as u32) - 1;
        let lower = (10 as i64).pow(n as u32 - 1);
        for i in (lower..=upper).rev() {
            let mut s = i.to_string();
            let s_rev = s.chars().rev().collect::<String>();
            let pal = (s + &s_rev).parse::<i64>().unwrap();
            for j in (lower..=upper).rev() {
                if j * j < pal {
                    break;
                }
                if pal % j == 0 {
                    return (pal % 1337) as i32;
                }
            }
        }
        0
    }
}