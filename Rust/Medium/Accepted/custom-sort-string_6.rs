impl Solution {
    pub fn custom_sort_string(order: String, s: String) -> String {
        
        let mut arr = [0; 26];
        let mut res = String::new();
        for c in s.chars() {
            arr[c as usize - 'a' as usize] += 1;
        }
        for c in order.chars() {
            let i = c as usize - 'a' as usize;
            if arr[i] > 0 {
                for _ in 0..arr[i] {
                    res.push(c);
                }
                arr[i] = 0;
            }
        }
        for i in 0..arr.len() {
            if arr[i] > 0 {
                for _ in 0..arr[i] {
                    res.push((i + 'a' as usize) as u8 as char);
                }
            }
        }
        res
    }
}