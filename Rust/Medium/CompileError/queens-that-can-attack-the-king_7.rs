impl Solution {
    pub fn queens_attackthe_king(queens: Vec<Vec<i32>>, king: Vec<i32>) -> Vec<Vec<i32>> {
        
        let mut queens = queens;
        let mut king = king;
        let mut result = Vec::new();
        let mut queens_set = HashSet::new();
        for queen in queens.iter() {
            queens_set.insert((queen[0], queen[1]));
        }
        let directions = vec![(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)];
        for (dx, dy) in directions.iter() {
            let mut x = king[0] + dx;
            let mut y = king[1] + dy;
            while x >= 0 && x < 8 && y >= 0 && y < 8 {
                if queens_set.contains(&(x, y)) {
                    result.push(vec![x, y]);
                    break;
                }
                x += dx;
                y += dy;
            }
        }
        result
    }
}