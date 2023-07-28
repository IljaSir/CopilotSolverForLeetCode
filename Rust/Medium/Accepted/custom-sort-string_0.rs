impl Solution {
    pub fn custom_sort_string(order: String, s: String) -> String {
        
        let mut count = [0; 26];
        for c in s.chars() {
            count[c as usize - 'a' as usize] += 1;
        }
        let mut result = String::new();
        for c in order.chars() {
            let i = c as usize - 'a' as usize;
            if count[i] > 0 {
                result.push_str(&c.to_string().repeat(count[i]));
                count[i] = 0;
            }
        }
        for (i, &n) in count.iter().enumerate() {
            if n > 0 {
                result.push_str(&((i as u8 + 'a' as u8) as char).to_string().repeat(n));
            }
        }
        result
    }
}