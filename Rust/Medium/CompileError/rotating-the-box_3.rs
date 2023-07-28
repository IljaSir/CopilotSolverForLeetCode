impl Solution {
    pub fn rotate_the_box(box: Vec<Vec<char>>) -> Vec<Vec<char>> {
        
        let m = box.len();
        let n = box[0].len();
        let mut box = box;
        let mut gravity = vec![vec![0; n]; m];
        for i in 0..m {
            for j in (0..n).rev() {
                if box[i][j] == '*' {
                    gravity[i][j] = 0;
                } else if box[i][j] == '#' {
                    gravity[i][j] = if i == m - 1 { 1 } else { gravity[i + 1][j] + 1 };
                } else {
                    gravity[i][j] = if i == m - 1 { 0 } else { gravity[i + 1][j] };
                }
            }
        }
        let mut result = vec![vec!['.'; m]; n];
        for i in 0..m {
            for j in 0..n {
                result[j][m - 1 - i] = if gravity[i][j] == 0 { box[i][j] } else { '.' };
                if gravity[i][j] > 0 {
                    result[j][m - gravity[i][j] - i] = '#';
                }
            }
        }
        result
    }
}