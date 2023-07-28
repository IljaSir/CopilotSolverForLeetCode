impl Solution {
    pub fn number_of_substrings(s: String) -> i32 {
        
        let mut count = 0;
        let mut start = 0;
        let mut end = 0;
        let mut count_a = 0;
        let mut count_b = 0;
        let mut count_c = 0;
        let mut s = s.chars().collect::<Vec<char>>();
        while end < s.len() {
            let end_char = s[end];
            match end_char {
                'a' => count_a += 1,
                'b' => count_b += 1,
                'c' => count_c += 1,
                _ => unreachable!(),
            }
            if count_a > 0 && count_b > 0 && count_c > 0 {
                count += s.len() - end;
                let start_char = s[start];
                match start_char {
                    'a' => count_a -= 1,
                    'b' => count_b -= 1,
                    'c' => count_c -= 1,
                    _ => unreachable!(),
                }
                start += 1;
            } else {
                end += 1;
            }
        }
        count as i32
    }
}