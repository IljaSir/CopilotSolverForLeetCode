impl Solution {
    pub fn find_content_children(g: Vec<i32>, s: Vec<i32>) -> i32 {
        
        let mut g = g;
        let mut s = s;
        g.sort();
        s.sort();
        let (mut i, mut j) = (0, 0);
        while i < g.len() && j < s.len() {
            if g[i] <= s[j] {
                i += 1;
            }
            j += 1;
        }
        i as i32
    }
}