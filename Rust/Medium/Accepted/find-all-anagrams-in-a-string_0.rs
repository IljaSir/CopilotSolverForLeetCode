impl Solution {
    pub fn find_anagrams(s: String, p: String) -> Vec<i32> {
        

        let mut res: Vec<i32> = vec![];
        let mut p_count: Vec<i32> = vec![0; 26];
        let mut s_count: Vec<i32> = vec![0; 26];
        let mut n = 0;
        for c in p.chars() {
            p_count[c as usize - 'a' as usize] += 1;
            n += 1;
        }
        let mut i = 0;
        for (j, c) in s.chars().enumerate() {
            s_count[c as usize - 'a' as usize] += 1;
            if j >= n {
                s_count[s.chars().nth(i).unwrap() as usize - 'a' as usize] -= 1;
                i += 1;
            }
            if s_count == p_count {
                res.push(i as i32);
            }
        }
        res
    }
}