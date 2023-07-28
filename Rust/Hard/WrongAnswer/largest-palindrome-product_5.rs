impl Solution {
    pub fn largest_palindrome(n: i32) -> i32 {
        
        if n == 1 { return 9; }
        let max = 10_i64.pow(n as u32) - 1;
        let min = max / 10;
        for i in (min..=max).rev() {
            let mut s = i.to_string();
            let mut t = s.clone();
            t.pop();
            s.push_str(&t.chars().rev().collect::<String>());
            let num = s.parse::<i64>().unwrap();
            for j in (min..=max).rev() {
                if num / j > max { break; }
                if num % j == 0 { return (num % 1337) as i32; }
            }
        }
        0
    }
}