impl Solution {
    pub fn queens_attackthe_king(queens: Vec<Vec<i32>>, king: Vec<i32>) -> Vec<Vec<i32>> {
        
        let mut result = Vec::new();
        let mut queen_set = std::collections::HashSet::new();
        for queen in queens {
            queen_set.insert((queen[0], queen[1]));
        }
        let mut x = king[0];
        let mut y = king[1];
        while x >= 0 && y >= 0 {
            if queen_set.contains(&(x, y)) {
                result.push(vec![x, y]);
                break;
            }
            x -= 1;
            y -= 1;
        }
        let mut x = king[0];
        let mut y = king[1];
        while x >= 0 && y < 8 {
            if queen_set.contains(&(x, y)) {
                result.push(vec![x, y]);
                break;
            }
            x -= 1;
            y += 1;
        }
        let mut x = king[0];
        let mut y = king[1];
        while x < 8 && y >= 0 {
            if queen_set.contains(&(x, y)) {
                result.push(vec![x, y]);
                break;
            }
            x += 1;
            y -= 1;
        }
        let mut x = king[0];
        let mut y = king[1];
        while x < 8 && y < 8 {
            if queen_set.contains(&(x, y)) {
                result.push(vec![x, y]);
                break;
            }
            x += 1;
            y += 1;
        }
        let mut x = king[0];
        let mut y = king[1];
        while x >= 0 {
            if queen_set.contains(&(x, y)) {
                result.push(vec![x, y]);
                break;
            }
            x -= 1;
        }
        let mut x = king[0];
        let mut y = king[1];
        while x < 8 {
            if queen_set.contains(&(x, y)) {
                result.push(vec![x, y]);
                break;
            }
            x += 1;
        }
        let mut x = king[0];
        let mut y = king[1];
        while y >= 0 {
            if queen_set.contains(&(x, y)) {
                result.push(vec![x, y]);
                break;
            }
            y -= 1;
        }
        let mut x =
    }
}