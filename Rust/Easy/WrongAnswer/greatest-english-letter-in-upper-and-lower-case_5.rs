impl Solution {
    pub fn greatest_letter(s: String) -> String {
        
        let mut s = s.as_bytes().to_vec();
        s.sort();
        let mut max = 0;
        let mut cnt = 0;
        for i in 0..s.len() {
            if s[i].is_ascii_uppercase() {
                cnt += 1;
                if cnt == 2 {
                    max = i;
                    break;
                }
            } else {
                cnt = 0;
            }
        }
        if max == 0 {
            String::new()
        } else {
            String::from_utf8(vec![s[max - 1]]).unwrap()
        }
    }
}