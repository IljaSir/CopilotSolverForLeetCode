impl Solution {
    pub fn largest_integer(num: i32) -> i32 {
        
        let mut digits = num.to_string().chars().collect::<Vec<char>>();
        let mut evens = Vec::new();
        let mut odds = Vec::new();
        for i in 0..digits.len() {
            if digits[i].to_digit(10).unwrap() % 2 == 0 {
                evens.push(i);
            } else {
                odds.push(i);
            }
        }
        let mut i = 0;
        let mut j = 0;
        while i < evens.len() && j < odds.len() {
            if evens[i] < odds[j] {
                digits.swap(evens[i], odds[j]);
                i += 1;
                j += 1;
            } else {
                j += 1;
            }
        }
        digits.iter().collect::<String>().parse::<i32>().unwrap()
    }
}