impl Solution {
    pub fn largest_palindrome(n: i32) -> i32 {
        
        if n == 1 {
            return 9;
        }
        let max = 10_i64.pow(n as u32) - 1;
        let min = 10_i64.pow(n as u32 - 1);
        for i in (min..=max).rev() {
            let mut s = i.to_string();
            let mut s2 = s.clone();
            s2.pop();
            s.push_str(&s2.chars().rev().collect::<String>());
            let num = s.parse::<i64>().unwrap();
            for j in (min..=max).rev() {
                if j * j <= num {
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