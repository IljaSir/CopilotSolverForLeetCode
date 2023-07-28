impl Solution {
    pub fn find_content_children(g: Vec<i32>, s: Vec<i32>) -> i32 {
        
        let mut g = g;
        let mut s = s;
        g.sort();
        s.sort();
        let mut ans = 0;
        let mut i = 0;
        for j in 0..s.len() {
            if i < g.len() && g[i] <= s[j] {
                ans += 1;
                i += 1;
            }
        }
        ans
    }
}