impl Solution {
    pub fn sort_sentence(s: String) -> String {
        
        let mut words: Vec<String> = vec!["".to_string(); 10];
        for word in s.split(" ") {
            let mut chars = word.chars();
            let mut ch = chars.next_back().unwrap();
            let mut num = 0;
            while ch.is_digit(10) {
                num += (ch as u8 - '0' as u8) as usize;
                num *= 10;
                ch = chars.next_back().unwrap();
            }
            num /= 10;
            words[num] = format!("{}{}", ch, chars.as_str());
        }
        words[1..].join(" ")
    }
}