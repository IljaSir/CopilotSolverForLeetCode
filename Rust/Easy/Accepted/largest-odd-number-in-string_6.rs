impl Solution {
    pub fn largest_odd_number(num: String) -> String {
        
        let mut ans = String::new();
        for (i, c) in num.chars().enumerate() {
            if c.to_digit(10).unwrap() % 2 == 1 {
                ans = num[0..=i].to_string();
            }
        }
        ans
    }
}