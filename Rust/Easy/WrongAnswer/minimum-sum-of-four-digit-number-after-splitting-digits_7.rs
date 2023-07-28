impl Solution {
    pub fn minimum_sum(num: i32) -> i32 {
        
        let mut num = num.to_string();
        let mut min = i32::max_value();
        for i in 1..num.len() {
            let mut new1 = num[..i].to_string();
            let mut new2 = num[i..].to_string();
            while new1.len() > 1 && new1.starts_with('0') {
                new1.remove(0);
            }
            while new2.len() > 1 && new2.starts_with('0') {
                new2.remove(0);
            }
            let new1 = new1.parse::<i32>().unwrap();
            let new2 = new2.parse::<i32>().unwrap();
            min = min.min(new1 + new2);
        }
        min
    }
}