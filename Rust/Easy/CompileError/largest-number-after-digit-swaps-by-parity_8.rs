impl Solution {
    pub fn largest_integer(num: i32) -> i32 {
        
        let mut num_s = num.to_string();
        let mut odd: Vec<char> = Vec::new();
        let mut even: Vec<char> = Vec::new();
        for c in num_s.chars() {
            if c.to_digit(10).unwrap() % 2 == 0 {
                even.push(c);
            } else {
                odd.push(c);
            }
        }
        even.sort();
        odd.sort();
        odd.reverse();
        let mut i = 0;
        for c in num_s.chars() {
            if c.to_digit(10).unwrap() % 2 == 0 {
                num_s.remove(i);
                num_s.insert(i, even.pop().unwrap());
            } else {
                num_s.remove(i);
                num_s.insert(i, odd.pop().unwrap());
            }
            i += 1;
        }
        num_s.parse::<i32>().unwrap()
    }
}