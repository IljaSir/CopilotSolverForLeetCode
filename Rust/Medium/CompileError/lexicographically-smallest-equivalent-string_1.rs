impl Solution {
    pub fn smallest_equivalent_string(s1: String, s2: String, base_str: String) -> String {
        
        let mut parent = [0; 26];
        for i in 0..26 {
            parent[i] = i;
        }
        let s1 = s1.as_bytes();
        let s2 = s2.as_bytes();
        for i in 0..s1.len() {
            let c1 = s1[i] - b'a';
            let c2 = s2[i] - b'a';
            let mut p1 = c1 as i32;
            let mut p2 = c2 as i32;
            while p1 != parent[p1 as usize] as i32 {
                p1 = parent[p1 as usize] as i32;
            }
            while p2 != parent[p2 as usize] as i32 {
                p2 = parent[p2 as usize] as i32;
            }
            parent[p1 as usize] = p2 as u8;
        }
        let mut res = String::new();
        let base_str = base_str.as_bytes();
        for i in 0..base_str.len() {
            let c = base_str[i] - b'a';
            let mut p = c as i32;
            while p != parent[p as usize] as i32 {
                p = parent[p as usize] as i32;
            }
            res.push((p + b'a') as char);
        }
        res
    }
}