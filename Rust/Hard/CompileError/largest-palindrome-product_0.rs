impl Solution {
    pub fn largest_palindrome(n: i32) -> i32 {
        
        if n == 1 {
            return 9;
        }
        let upper = 10_i64.pow(n as u32) - 1;
        let lower = 10_i64.pow(n as u32 - 1);
        for i in (lower..=upper).rev() {
            let mut num = i.to_string();
            for c in num.chars().rev() {
                num.push(c);
            }
            let num = num.parse::<i64>().unwrap();
            for j in (lower..=upper).rev() {
                if num / j > upper {
                    break;
                }
                if num % j == 0 {
                    return (num % 1337) as i32;
                }
            }
        }
        0
    }
}