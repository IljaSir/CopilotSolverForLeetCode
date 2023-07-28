impl Solution {
    pub fn longest_beautiful_substring(word: String) -> i32 {
        
        let mut longest = 0;
        let mut start = 0;
        let mut end = 0;
        let mut prev = 0;
        for c in word.chars() {
            let i = match c {
                'a' => 0,
                'e' => 1,
                'i' => 2,
                'o' => 3,
                'u' => 4,
                _ => unreachable!(),
            };
            if i >= prev {
                if i > prev {
                    start = end;
                }
                end += 1;
                if i == 4 {
                    longest = longest.max(end - start);
                }
            } else {
                start = end;
            }
            prev = i;
        }
        longest as i32
    }
}