impl Solution {
    pub fn smallest_string_with_swaps(s: String, pairs: Vec<Vec<i32>>) -> String {
        
        let mut s = s.into_bytes();
        let n = s.len();
        let mut uf = UnionFind::new(n);
        for p in pairs {
            uf.union(p[0] as usize, p[1] as usize);
        }
        let mut map = std::collections::HashMap::new();
        for i in 0..n {
            let root = uf.find(i);
            map.entry(root).or_insert_with(Vec::new).push(i);
        }
        for (_, v) in map {
            let mut t = Vec::new();
            for i in v {
                t.push(s[i]);
            }
            t.sort();
            for (i, j) in v.into_iter().zip(t.into_iter()) {
                s[i] = j;
            }
        }
        String::from_utf8(s).unwrap()
    }
}