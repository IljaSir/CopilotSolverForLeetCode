impl Solution {
    pub fn reorganize_string(s: String) -> String {
        
        let mut count = vec![0; 26];
        for c in s.chars() {
            count[c as usize - 'a' as usize] += 100;
        }
        for i in 0..26 {
            count[i] += i as i32;
        }
        count.sort();
        let mut res = vec![0; s.len()];
        let mut t = 1;
        for i in 0..26 {
            let c = (count[i] % 100) as u8;
            let cnt = (count[i] / 100) as usize;
            if cnt > (s.len() + 1) / 2 {
                return "".to_string();
            }
            for _ in 0..cnt {
                if t >= s.len() {
                    t = 0;
                }
                res[t] = c;
                t += 2;
            }
        }
        res.iter().map(|&x| x as char).collect()
    }
}