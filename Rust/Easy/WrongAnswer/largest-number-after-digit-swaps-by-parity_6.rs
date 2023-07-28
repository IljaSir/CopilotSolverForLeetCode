impl Solution {
    pub fn largest_integer(num: i32) -> i32 {
        
        let mut digits = num.to_string().chars().collect::<Vec<_>>();
        let mut odd = Vec::new();
        let mut even = Vec::new();
        for (i, c) in digits.iter().enumerate() {
            if c.to_digit(10).unwrap() % 2 == 0 {
                even.push((i, *c));
            } else {
                odd.push((i, *c));
            }
        }
        let (mut i, mut j) = (0, 0);
        while i < even.len() && j < odd.len() {
            if even[i].1 < odd[j].1 {
                digits.swap(even[i].0, odd[j].0);
                i += 1;
                j += 1;
            } else {
                j += 1;
            }
        }
        digits.iter().collect::<String>().parse::<i32>().unwrap()
    }
}