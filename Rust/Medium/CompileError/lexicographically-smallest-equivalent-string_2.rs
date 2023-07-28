impl Solution {
    pub fn smallest_equivalent_string(s1: String, s2: String, base_str: String) -> String {
        
        let mut parents = vec![0; 26];
        for i in 0..26 {
            parents[i] = i;
        }
        let s1 = s1.as_bytes();
        let s2 = s2.as_bytes();
        for i in 0..s1.len() {
            let p1 = Self::find(&mut parents, (s1[i] - b'a') as usize);
            let p2 = Self::find(&mut parents, (s2[i] - b'a') as usize);
            if p1 != p2 {
                parents[p1] = p2;
            }
        }
        let mut res = Vec::new();
        for b in base_str.as_bytes() {
            let p = Self::find(&mut parents, (b - b'a') as usize);
            res.push((p + b'a') as char);
        }
        res.into_iter().collect()
    }
    fn find(parents: &mut Vec<usize>, i: usize) -> usize {
        if parents[i] != i {
            parents[i] = Self::find(parents, parents[i]);
        }
        parents[i]
    }
}