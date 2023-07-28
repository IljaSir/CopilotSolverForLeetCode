impl Solution {
    pub fn largest_odd_number(num: String) -> String {
        
        let mut n = num.len();
        let mut res = String::new();
        let mut flag = false;
        for i in num.chars() {
            if i.to_digit(10).unwrap() % 2 == 1 {
                flag = true;
            }
            if flag {
                res.push(i);
            }
            n -= 1;
        }
        res
    }
}