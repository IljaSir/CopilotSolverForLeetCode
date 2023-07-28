impl Solution {
    pub fn minimum_sum(num: i32) -> i32 {
        
        let mut num = num.to_string();
        let mut min = 10000;
        for i in 1..num.len() {
            let mut l = num[..i].to_string();
            let mut r = num[i..].to_string();
            if l.starts_with('0') {
                l = l[1..].to_string();
            }
            if r.starts_with('0') {
                r = r[1..].to_string();
            }
            let sum = l.parse::<i32>().unwrap() + r.parse::<i32>().unwrap();
            if sum < min {
                min = sum;
            }
        }
        min
    }
}