impl Solution {
    pub fn alphabet_board_path(target: String) -> String {
        
        let mut ans = String::new();
        let mut x = 0;
        let mut y = 0;
        for c in target.chars() {
            let (nx, ny) = ((c as i32 - 'a' as i32) % 5, (c as i32 - 'a' as i32) / 5);
            if ny > y {
                for _ in 0..(ny - y) {
                    ans.push('D');
                }
            } else if ny < y {
                for _ in 0..(y - ny) {
                    ans.push('U');
                }
            }
            if nx > x {
                for _ in 0..(nx - x) {
                    ans.push('R');
                }
            } else if nx < x {
                for _ in 0..(x - nx) {
                    ans.push('L');
                }
            }
            ans.push('!');
            x = nx;
            y = ny;
        }
        ans
    }
}