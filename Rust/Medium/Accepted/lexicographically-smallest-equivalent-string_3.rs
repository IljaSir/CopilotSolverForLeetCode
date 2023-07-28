impl Solution {
    pub fn smallest_equivalent_string(s1: String, s2: String, base_str: String) -> String {
        
        let mut s1 = s1.as_bytes().to_vec();
        let mut s2 = s2.as_bytes().to_vec();
        let mut base_str = base_str.as_bytes().to_vec();
        let mut parent = vec![0; 26];
        for i in 0..26 { parent[i] = i; }
        for i in 0..s1.len() {
            let x = (s1[i] - b'a') as usize;
            let y = (s2[i] - b'a') as usize;
            let x = Solution::find_parent(&mut parent, x);
            let y = Solution::find_parent(&mut parent, y);
            if x < y {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
        for i in 0..base_str.len() {
            let x = (base_str[i] - b'a') as usize;
            let x = Solution::find_parent(&mut parent, x);
            base_str[i] = (x as u8) + b'a';
        }
        String::from_utf8(base_str).unwrap()
    }
    fn find_parent(parent: &mut Vec<usize>, mut x: usize) -> usize {
        while parent[x] != x {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        x
    }
}