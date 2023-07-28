impl Solution {
    pub fn vowel_strings(words: Vec<String>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut ans = Vec::new();
        let mut v = Vec::new();
        for i in 0..words.len() {
            let mut cnt = 0;
            for c in words[i].chars() {
                if c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' {
                    cnt += 1;
                }
            }
            v.push(cnt);
        }
        for q in queries {
            let mut cnt = 0;
            for i in q[0] as usize..=q[1] as usize {
                cnt += v[i];
            }
            ans.push(cnt);
        }
        ans
    }
}