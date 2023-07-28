impl Solution {
    pub fn find_anagrams(s: String, p: String) -> Vec<i32> {
        

        let mut res = vec![];
        let mut s = s.chars().collect::<Vec<_>>();
        let mut p = p.chars().collect::<Vec<_>>();
        p.sort();
        let n = s.len();
        let m = p.len();
        for i in 0..=n - m {
            let mut tmp = s[i..i + m].to_vec();
            tmp.sort();
            if tmp == p {
                res.push(i as i32);
            }
        }
        res
    }
}