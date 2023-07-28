impl Solution {
    pub fn largest_integer(num: i32) -> i32 {
        
        let mut num = num.to_string();
        let mut odds = Vec::new();
        let mut evens = Vec::new();
        for ch in num.chars() {
            if ch.to_digit(10).unwrap() % 2 == 0 {
                evens.push(ch);
            } else {
                odds.push(ch);
            }
        }
        odds.sort();
        evens.sort();
        odds.reverse();
        evens.reverse();
        let mut result = String::new();
        let mut odd_index = 0;
        let mut even_index = 0;
        for ch in num.chars() {
            if ch.to_digit(10).unwrap() % 2 == 0 {
                result.push(evens[even_index]);
                even_index += 1;
            } else {
                result.push(odds[odd_index]);
                odd_index += 1;
            }
        }
        result.parse::<i32>().unwrap()
    }
}