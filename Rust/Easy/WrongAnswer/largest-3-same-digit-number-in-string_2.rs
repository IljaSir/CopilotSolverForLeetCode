impl Solution {
    pub fn largest_good_integer(num: String) -> String {
        
        let mut count = [0; 10];
        for c in num.chars() {
            count[c as usize - '0' as usize] += 1;
        }
        let mut res = String::new();
        for i in (0..10).rev() {
            if count[i] > 0 {
                res.push_str(&(i.to_string().repeat(count[i].min(3))));
            }
        }
        res
    }
}