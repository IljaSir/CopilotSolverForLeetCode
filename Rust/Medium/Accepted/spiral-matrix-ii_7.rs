impl Solution {
    pub fn generate_matrix(n: i32) -> Vec<Vec<i32>> {
        

        let mut matrix = vec![vec![0; n as usize]; n as usize];
        let mut num = 1;
        let mut x1 = 0;
        let mut x2 = n - 1;
        let mut y1 = 0;
        let mut y2 = n - 1;
        while x1 <= x2 && y1 <= y2 {
            for i in x1..=x2 {
                matrix[y1 as usize][i as usize] = num;
                num += 1;
            }
            y1 += 1;
            for i in y1..=y2 {
                matrix[i as usize][x2 as usize] = num;
                num += 1;
            }
            x2 -= 1;
            for i in (x1..=x2).rev() {
                matrix[y2 as usize][i as usize] = num;
                num += 1;
            }
            y2 -= 1;
            for i in (y1..=y2).rev() {
                matrix[i as usize][x1 as usize] = num;
                num += 1;
            }
            x1 += 1;
        }
        matrix
    }
}