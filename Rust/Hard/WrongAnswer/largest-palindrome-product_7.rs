impl Solution {
    pub fn largest_palindrome(n: i32) -> i32 {
        
        let upper = 10_i64.pow(n as u32) - 1;
        let lower = 10_i64.pow(n as u32 - 1);
        let mut result = 0;
        for i in (lower..=upper).rev() {
            let mut left = i.to_string();
            let right = left.chars().rev().collect::<String>();
            left.push_str(&right);
            let palindrome = left.parse::<i64>().unwrap();
            for j in (lower..=upper).rev() {
                if palindrome / j > upper {
                    break;
                }
                if palindrome % j == 0 {
                    result = palindrome % 1337;
                    break;
                }
            }
            if result != 0 {
                break;
            }
        }
        result as i32
    }
}