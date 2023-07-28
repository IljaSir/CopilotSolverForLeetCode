impl Solution {
    pub fn largest_palindrome(n: i32) -> i32 {
        
        if n == 1 {
            return 9;
        }
        let max = 10_i64.pow(n as u32) - 1;
        let min = 10_i64.pow(n as u32 - 1);
        for i in (min..=max).rev() {
            let num = format!("{}{}", i, i.to_string().chars().rev().collect::<String>()).parse::<i64>().unwrap();
            for j in (min..=max).rev() {
                if num / j > max || j * j < num {
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