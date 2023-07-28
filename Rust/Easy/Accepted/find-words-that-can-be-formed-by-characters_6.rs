impl Solution {
    pub fn count_characters(words: Vec<String>, chars: String) -> i32 {
        
        let mut counter = vec![0; 26];
        let mut result = 0;
        for c in chars.chars() {
            counter[c as usize - 'a' as usize] += 1;
        }
        for word in words {
            let mut tmp = counter.clone();
            let mut flag = true;
            for c in word.chars() {
                if tmp[c as usize - 'a' as usize] == 0 {
                    flag = false;
                    break;
                } else {
                    tmp[c as usize - 'a' as usize] -= 1;
                }
            }
            if flag {
                result += word.len();
            }
        }
        result as i32
    }
}