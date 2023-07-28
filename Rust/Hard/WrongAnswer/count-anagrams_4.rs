impl Solution {
    pub fn count_anagrams(s: String) -> i32 {
        
        let mut v = Vec::new();
        let mut i = 0;
        let mut j = 0;
        let mut res = 0;
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        for c in s.chars() {
            if c == ' ' {
                v.push(&s[i..j]);
                i = j + 1;
            }
            j += 1;
        }
        v.push(&s[i..j]);
        for i in 0..v.len() {
            let mut v = v[i].chars().collect::<Vec<char>>();
            v.sort();
            let s = v.into_iter().collect::<String>();
            if let Some(x) = map.get(&s) {
                count += *x;
                *map.get_mut(&s).unwrap() += 1;
            } else {
                map.insert(s, 1);
            }
        }
        res = (count * 2 + v.len()) as i32 % 1000000007;
        res
    }
}