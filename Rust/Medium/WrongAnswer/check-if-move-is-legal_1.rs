impl Solution {
    pub fn check_move(board: Vec<Vec<char>>, r_move: i32, c_move: i32, color: char) -> bool {
        
        let (r_move, c_move) = (r_move as usize, c_move as usize);
        let mut board = board;
        board[r_move][c_move] = color;
        let mut ans = false;
        for &delta in &[(0, 1), (1, 0), (1, 1), (1, -1)] {
            let mut cnt = 1;
            for &sign in &[-1, 1] {
                let mut r = r_move as i32 + sign * delta.0;
                let mut c = c_move as i32 + sign * delta.1;
                while r >= 0 && r < 8 && c >= 0 && c < 8 && board[r as usize][c as usize] != color {
                    if board[r as usize][c as usize] == '.' {
                        break;
                    }
                    cnt += 1;
                    r += sign * delta.0;
                    c += sign * delta.1;
                }
            }
            if cnt >= 3 {
                ans = true;
                break;
            }
        }
        ans
    }
}