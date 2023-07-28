impl Solution {
    pub fn num_matching_subseq(s: String, words: Vec<String>) -> i32 {
        
        let mut ans = 0;
        let mut map = [Vec::new(); 26];
        for (i, c) in s.chars().enumerate() {
            map[c as usize - 'a' as usize].push(i);
        }
        'outer: for word in words {
            let mut last = -1;
            for c in word.chars() {
                let mut found = false;
                for &i in &map[c as usize - 'a' as usize] {
                    if i > last {
                        last = i;
                        found = true;
                        break;
                    }
                }
                if !found {
                    continue 'outer;
                }
            }
            ans += 1;
        }
        ans
    }
}