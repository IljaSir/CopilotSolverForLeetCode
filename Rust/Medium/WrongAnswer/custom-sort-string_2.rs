impl Solution {
    pub fn custom_sort_string(order: String, s: String) -> String {
        
        let mut map = vec![0; 26];
        for c in s.chars() {
            map[c as usize - 'a' as usize] += 1;
        }
        let mut res = String::new();
        for c in order.chars() {
            let cnt = map[c as usize - 'a' as usize];
            for _ in 0..cnt {
                res.push(c);
            }
        }
        for c in 'a' as u8..'z' as u8 + 1 {
            let cnt = map[c as usize - 'a' as usize];
            for _ in 0..cnt {
                res.push(c as char);
            }
        }
        res
    }
}