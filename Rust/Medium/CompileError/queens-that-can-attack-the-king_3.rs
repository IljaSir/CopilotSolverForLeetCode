impl Solution {
    pub fn queens_attackthe_king(queens: Vec<Vec<i32>>, king: Vec<i32>) -> Vec<Vec<i32>> {
        
        let mut res = Vec::new();
        let mut dir = vec![vec![0; 8]; 8];
        for queen in queens {
            dir[queen[0] as usize][queen[1] as usize] = 1;
        }
        let mut x = king[0];
        let mut y = king[1];
        while x >= 0 && y >= 0 {
            if dir[x as usize][y as usize] == 1 {
                res.push(vec![x, y]);
                break;
            }
            x -= 1;
            y -= 1;
        }
        let mut x = king[0];
        let mut y = king[1];
        while x >= 0 && y < 8 {
            if dir[x as usize][y as usize] == 1 {
                res.push(vec![x, y]);
                break;
            }
            x -= 1;
            y += 1;
        }
        let mut x = king[0];
        let mut y = king[1];
        while x < 8 && y >= 0 {
            if dir[x as usize][y as usize] == 1 {
                res.push(vec![x, y]);
                break;
            }
            x += 1;
            y -= 1;
        }
        let mut x = king[0];
        let mut y = king[1];
        while x < 8 && y < 8 {
            if dir[x as usize][y as usize] == 1 {
                res.push(vec![x, y]);
                break;
            }
            x += 1;
            y += 1;
        }
        let mut x = king[0];
        let mut y = king[1];
        while x >= 0 {
            if dir[x as usize][y as usize] == 1 {
                res.push(vec![x, y]);
                break;
            }
            x -= 1;
        }
        let mut x = king[0];
        let mut y = king[1];
        while x < 8 {
            if dir[x as usize][y as usize] == 1 {
                res.push(vec![x, y]);
                break;
            }
            x += 1;
        }
        let mut x = king[0];
        let mut y = king[1];
        while y >= 0 {
            if dir
    }
}