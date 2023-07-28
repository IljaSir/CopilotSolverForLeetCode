impl Solution {
    pub fn frequency_sort(s: String) -> String {
        

        let mut s = s.into_bytes();
        s.sort_unstable();
        let mut res = Vec::new();
        let mut idx = 0;
        while idx < s.len() {
            let mut cnt = 1;
            while idx + 1 < s.len() && s[idx] == s[idx+1] {
                cnt += 1;
                idx += 1;
            }
            res.push((cnt, s[idx]));
            idx += 1;
        }
        res.sort_unstable_by(|a, b| b.0.cmp(&a.0));
        let mut res_s = String::new();
        for (cnt, ch) in res {
            res_s.push_str(&ch.to_string().repeat(cnt));
        }
        res_s
    }
}