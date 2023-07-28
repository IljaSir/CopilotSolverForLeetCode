impl Solution {
    pub fn partition_string(s: String) -> i32 {
        
        let mut v = Vec::new();
        for c in s.chars() {
            let i = c as usize - 'a' as usize;
            if v.len() <= i {
                v.resize(i+1, 0);
            }
            v[i] += 1;
        }
        let mut res = 0;
        let mut max = 0;
        for i in 0..v.len() {
            if v[i] == 0 {
                continue;
            }
            if i > max {
                max = i;
                res += 1;
            }
            if v[i] > v[max] {
                max = i;
            }
        }
        res
    }
}