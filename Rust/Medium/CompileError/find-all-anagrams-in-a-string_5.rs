impl Solution {
    pub fn find_anagrams(s: String, p: String) -> Vec<i32> {
        

        let mut res = vec![];
        let mut s = s.chars().collect::<Vec<char>>();
        let mut p = p.chars().collect::<Vec<char>>();
        let mut p_map = vec![0; 26];
        for c in p {
            p_map[c as usize - 'a' as usize] += 1;
        }
        let mut s_map = vec![0; 26];
        for i in 0..s.len() {
            s_map[s[i] as usize - 'a' as usize] += 1;
            if i >= p.len() {
                s_map[s[i - p.len()] as usize - 'a' as usize] -= 1;
            }
            if s_map == p_map {
                res.push(i as i32 - p.len() as i32 + 1);
            }
        }
        res
    }
}