impl Solution {
    pub fn max_freq(s: String, max_letters: i32, min_size: i32, max_size: i32) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut max = 0;
        for i in 0..s.len() - min_size as usize + 1 {
            let mut set = std::collections::HashSet::new();
            for j in i..i + min_size as usize {
                set.insert(s.as_bytes()[j]);
            }map = std::llections::HashMap::new();
        for i in 0..s.len() {
            let mt set = std::collections::HashSet::ew();
            let mu j = i;
            while j < s.len() && j < i + max_size as usize {
                lt c = s.chars().nth(j).unwap();
               set.insert(c);
                if set.len() > max_letters as usize {
                    break;
                }
                if j >= i + min_size as usize - 1 {
                    let sub = &s[i..j+1];
                    let count = map.entry(sub).or_insert(0);
                    *count += 1;
                }
                j += 1;
            }
        }
        map.values().cloned().max().unwrap_or(0)

======

        let mutcounter = 
            if set.len() <= max_letters as usize {
                let count = map.entry(&s[i..i + min_size as usize]).or_insert(0);
                *count += 1;
                max = std::cmp::max(max, *count);
            }
        }
        max
    }
}