impl Solution {
    pub fn find_anagrams(s: String, p: String) -> Vec<i32> {
        

        let mut res = Vec::new();
        let mut map = [0; 26];
        for c in p.chars() {
            map[c as usize - 'a' as usize] += 1;
        }
        let mut count = p.len() as i32;
        let mut i = 0;
        let mut j = 0;
        while j < s.len() {
            let c = s.chars().nth(j).unwrap();
            if map[c as usize - 'a' as usize] > 0 {
                count -= 1;
            }
            map[c as usize - 'a' as usize] -= 1;
            if j - i + 1 > p.len() {
                let c = s.chars().nth(i).unwrap();
                if map[c as usize - 'a' as usize] >= 0 {
                    count += 1;
                }
                map[c as usize - 'a' as usize] += 1;
                i += 1;
            }
            if count == 0 {
                res.push(i as i32);
            }
            j += 1;
        }
        res
    }
}