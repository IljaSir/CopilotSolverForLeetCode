impl Solution {
    pub fn queens_attackthe_king(queens: Vec<Vec<i32>>, king: Vec<i32>) -> Vec<Vec<i32>> {
        
        let mut result = Vec::new();
        let mut board = [[false; 8]; 8];
        for queen in queens {
            board[queen[0] as usize][queen[1] as usize] = true;
        }
        for i in 0..8 {
            let mut x = king[0] + i;
            let mut y = king[1] + i;
            if x < 8 && y < 8 && board[x as usize][y as usize] {
                result.push(vec![x, y]);
                break;
            }
            x = king[0] - i;
            y = king[1] - i;
            if x >= 0 && y >= 0 && board[x as usize][y as usize] {
                result.push(vec![x, y]);
                break;
            }
            x = king[0] + i;
            y = king[1] - i;
            if x < 8 && y >= 0 && board[x as usize][y as usize] {
                result.push(vec![x, y]);
                break;
            }
            x = king[0] - i;
            y = king[1] + i;
            if x >= 0 && y < 8 && board[x as usize][y as usize] {
                result.push(vec![x, y]);
                break;
            }
        }
        for i in 0..8 {
            let mut x = king[0] + i;
            let mut y = king[1];
            if x < 8 && board[x as usize][y as usize] {
                result.push(vec![x, y]);
                break;
            }
            x = king[0] - i;
            y = king[1];
            if x >= 0 && board[x as usize][y as usize] {
                result.push(vec![x, y]);
                break;
            }
            x = king[0];
            y = king[1] + i;
            if y < 8 && board[x as usize][y as usize] {
                result.push(vec![x, y]);
                break;
            }
            x = king[0];
            y = king[1] - i;
            if y >= 0 && board[x as usize][y as usize] {
                result.push(vec![x, y]);
                break;
            }
        }
        result
    }
}