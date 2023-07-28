impl Solution {
    pub fn minimum_recolors(blocks: String, k: i32) -> i32 {
        
        let mut ans = 0;
        let mut cnt = 0;
        let mut pre = 'W';
        for c in blocks.chars() {
            if c == pre {
                cnt += 1;
            } else {
                ans += (cnt + k - 1) / k - 1;
                cnt = 1;
                pre = c;
            }
        }
        ans + (cnt + k - 1) / k - 1
    }
}