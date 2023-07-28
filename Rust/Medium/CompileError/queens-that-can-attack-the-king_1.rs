impl Solution {
    pub fn queens_attackthe_king(queens: Vec<Vec<i32>>, king: Vec<i32>) -> Vec<Vec<i32>> {
        
        let mut result = Vec::new();
        let mut board = [[0; 8]; 8];
        for queen in queens {
            board[queen[0] as usize][queen[1] as usize] = 1;
        }
        let king = (king[0] as usize, king[1] as usize);
        let (mut x, mut y) = king;
        while x > 0 && y > 0 {
            x -= 1;
            y -= 1;
            if board[x][y] == 1 {
                result.push(vec![x as i32, y as i32]);
                break;
            }
        }
        let (mut x, mut y) = king;
        while x < 7 && y < 7 {
            x += 1;
            y += 1;
            if board[x][y] == 1 {
                result.push(vec![x as i32, y as i32]);
                break;
            }
        }
        let (mut x, mut y) = king;
        while x < 7 && y > 0 {
            x += 1;
            y -= 1;
            if board[x][y] == 1 {
                result.push(vec![x as i32, y as i32]);
                break;
            }
        }
        let (mut x, mut y) = king;
        while x > 0 && y < 7 {
            x -= 1;
            y += 1;
            if board[x][y] == 1 {
                result.push(vec![x as i32, y as i32]);
                break;
            }
        }
        let (mut x, mut y) = king;
        while x > 0 {
            x -= 1;
            if board[x][y] == 1 {
                result.push(vec![x as i32, y as i32]);
                break;
            }
        }
        let (mut x, mut y) = king;
        while x < 7 {
            x += 1;
            if board[x][y] == 1 {
                result.push(vec![x as i32, y as i32]);
                break;
            }
        }
        let (mut x, mut y) = king;
        while y > 0 {
            y -= 1;
            if board[x][y] == 1 {
    }
}