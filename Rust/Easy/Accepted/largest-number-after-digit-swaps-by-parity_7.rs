impl Solution {
    pub fn largest_integer(num: i32) -> i32 {
        
        let num_str = num.to_string();
        let mut num_vec: Vec<char> = num_str.chars().collect();
        let mut even_vec: Vec<char> = Vec::new();
        let mut odd_vec: Vec<char> = Vec::new();
        for c in num_vec.iter() {
            if c.to_digit(10).unwrap() % 2 == 0 {
                even_vec.push(*c);
            } else {
                odd_vec.push(*c);
            }
        }
        even_vec.sort_by(|a, b| b.cmp(a));
        odd_vec.sort_by(|a, b| b.cmp(a));
        let mut even_iter = even_vec.iter();
        let mut odd_iter = odd_vec.iter();
        let mut result: Vec<char> = Vec::new();
        for c in num_vec.iter() {
            if c.to_digit(10).unwrap() % 2 == 0 {
                if let Some(e) = even_iter.next() {
                    result.push(*e);
                } else {
                    result.push(*c);
                }
            } else {
                if let Some(o) = odd_iter.next() {
                    result.push(*o);
                } else {
                    result.push(*c);
                }
            }
        }
        let result_str: String = result.iter().collect();
        result_str.parse::<i32>().unwrap()
    }
}