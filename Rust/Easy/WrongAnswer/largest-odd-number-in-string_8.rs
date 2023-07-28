impl Solution {
    pub fn largest_odd_number(num: String) -> String {
        
        let mut num = num;
        let mut index = 0;
        for (i, c) in num.chars().enumerate() {
            if c.to_digit(10).unwrap() % 2 == 1 {
                index = i;
            }
        }
        if index == 0 {
            return "".to_string();
        }
        num.truncate(index + 1);
        num
    }
}