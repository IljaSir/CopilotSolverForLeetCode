impl Solution {
    pub fn find_content_children(g: Vec<i32>, s: Vec<i32>) -> i32 {
        
        let mut g = g;
        g.sort();
        let mut s = s;
        s.sort();
        let mut i = 0;
        let mut j = 0;
        let mut ans = 0;
        while i < g.len() && j < s.len() {
            if g[i] <= s[j] {
                ans += 1;
                i += 1;
                j += 1;
            } else {
                j += 1;
            }
        }
        ans
    }
}