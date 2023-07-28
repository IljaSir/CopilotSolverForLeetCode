impl Solution {
    pub fn largest_good_integer(num: String) -> String {
        
        let mut count = vec![0; 10];
        for c in num.chars() {
            count[c as usize - '0' as usize] += 1;
        }
        let mut result = String::new();
        for i in (0..10).rev() {
            let mut c = count[i];
            while c > 0 {
                result.push((i as u8 + '0' as u8) as char);
                c -= 1;
            }
        }
        result
    }
}