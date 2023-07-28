impl Solution {
    pub fn vowel_strings(words: Vec<String>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut ans = vec![];
        let mut vowels = vec![0; words.len()];
        for i in 0..words.len() {
            let mut count = 0;
            for c in words[i].chars() {
                if c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' {
                    count += 1;
                }
            }
            vowels[i] = count;
        }
        for q in queries {
            let mut count = 0;
            for i in q[0] as usize..q[1] as usize + 1 {
                count += vowels[i];
            }
            ans.push(count);
        }
        ans
    }
}