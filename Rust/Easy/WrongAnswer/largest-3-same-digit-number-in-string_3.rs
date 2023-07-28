impl Solution {
    pub fn largest_good_integer(num: String) -> String {
        
        let mut cnt = vec![0; 10];
        for c in num.chars() {
            cnt[(c as u8 - '0' as u8) as usize] += 1;
        }
        let mut res = String::new();
        for i in (1..10).rev() {
            while cnt[i] > 0 {
                res.push((i as u8 + '0' as u8) as char);
                cnt[i] -= 1;
            }
        }
        res
    }
}