impl Solution {
    pub fn queens_attackthe_king(queens: Vec<Vec<i32>>, king: Vec<i32>) -> Vec<Vec<i32>> {
        
        let mut queens = queens;
        let mut king = king;
        let mut result: Vec<Vec<i32>> = Vec::new();
        let mut directions: Vec<Vec<i32>> = vec![vec![1, 0], vec![-1, 0], vec![0, 1], vec![0, -1], vec![1, 1], vec![1, -1], vec![-1, 1], vec![-1, -1]];
        for dir in directions {
            let mut x = king[0] + dir[0];
            let mut y = king[1] + dir[1];
            while x >= 0 && x < 8 && y >= 0 && y < 8 {
                let queen = vec![x, y];
                if queens.contains(&queen) {
                    result.push(queen);
                    break;
                }
                x += dir[0];
                y += dir[1];
            }
        }
        result
    }
}