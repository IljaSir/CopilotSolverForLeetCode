impl Solution {
    pub fn alphabet_board_path(target: String) -> String {
        
        let mut ans = String::new();
        let mut cur = (0, 0);
        for c in target.chars() {
            let mut pos = (0, 0);
            if c == 'z' {
                pos = (5, 0);
            } else {
                pos = ((c as u8 - 'a' as u8) / 5, (c as u8 - 'a' as u8) % 5);
            }
            if pos.0 > cur.0 {
                for _ in 0..(pos.0 - cur.0) {
                    ans.push('D');
                }
            } else if pos.0 < cur.0 {
                for _ in 0..(cur.0 - pos.0) {
                    ans.push('U');
                }
            }
            if pos.1 > cur.1 {
                for _ in 0..(pos.1 - cur.1) {
                    ans.push('R');
                }
            } else if pos.1 < cur.1 {
                for _ in 0..(cur.1 - pos.1) {
                    ans.push('L');
                }
            }
            ans.push('!');
            cur = pos;
        }
        ans
    }
}