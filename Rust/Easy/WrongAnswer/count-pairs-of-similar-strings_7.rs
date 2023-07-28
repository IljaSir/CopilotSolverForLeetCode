impl Solution {
    pub fn similar_pairs(words: Vec<String>) -> i32 {
        
        let mut ans = 0;
        let mut map = vec![0; 26];
        for i in 0..words.len() {
            for j in i + 1..words.len() {
                if words[i].len() != words[j].len() {
                    continue;
                }
                for k in 0..26 {
                    map[k] = 0;
                }
                let mut flag = true;
                for k in 0..words[i].len() {
                    let a = words[i].chars().nth(k).unwrap() as usize - 'a' as usize;
                    let b = words[j].chars().nth(k).unwrap() as usize - 'a' as usize;
                    map[a] += 1;
                    map[b] -= 1;
                    if map[a] < 0 {
                        flag = false;
                        break;
                    }
                }
                if flag {
                    ans += 1;
                }
            }
        }
        ans
    }
}